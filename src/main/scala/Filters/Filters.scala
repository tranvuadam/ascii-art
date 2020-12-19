package Filters

import Grids.GreyColorGrid


trait Filter{
  def applyFilter(greyColorGrid: GreyColorGrid): GreyColorGrid
}

class InvertFilter() extends Filter {
  override def applyFilter(greyColorGrid: GreyColorGrid): GreyColorGrid = {
    for {
      h1 <- (0 until greyColorGrid.height)
      w1 <- (0 until greyColorGrid.width)
    } yield {
      greyColorGrid.greyValues(h1)(w1) = 255 - greyColorGrid.greyValues(h1)(w1)
    }
    greyColorGrid
  }
}

class BrightnessFilter(brightness: String) extends Filter {

  def checkOverflow(value: Int): Int = if (value < 0) 0 else if(value > 255) 255 else value

  override def applyFilter(greyColorGrid: GreyColorGrid): GreyColorGrid = {
    val brightnessValue = brightness.toInt
    println(brightnessValue)
    for {
      h1 <- (0 until greyColorGrid.height)
      w1 <- (0 until greyColorGrid.width)
    } yield {
      greyColorGrid.greyValues(h1)(w1) = checkOverflow(greyColorGrid.greyValues(h1)(w1) + brightnessValue)
    }
    greyColorGrid
  }
}

class FlipFilter(axis: String) extends Filter {
  override def applyFilter(greyColorGrid: GreyColorGrid): GreyColorGrid = {
    if(axis.toUpperCase == "Y")
      flipVertically(greyColorGrid)
    else if(axis.toUpperCase == "X")
      flipHorizontally(greyColorGrid)
    else throw new IllegalArgumentException("Invalid Flip filter option! Available arguments: y/x")
  }

  def flipHorizontally(grid: GreyColorGrid): GreyColorGrid ={
    for{
      y <- 0 until grid.width
      x <- 0 until grid.height/2
    }yield{
      val tmpChar = grid.greyValues(grid.height-x-1)(y)
      grid.greyValues(grid.height-x-1)(y) = grid.greyValues(x)(y)
      grid.greyValues(x)(y) = tmpChar
    }
    grid
  }
  def flipVertically(grid: GreyColorGrid): GreyColorGrid ={
    for{
      x <- 0 until grid.height
      y <- 0 until grid.width/2
    }yield{
      val tmpChar = grid.greyValues(x)(grid.width - y - 1)
      grid.greyValues(x)(grid.width - y - 1) = grid.greyValues(x)(y)
      grid.greyValues(x)(y) = tmpChar
    }
    grid
  }
}
