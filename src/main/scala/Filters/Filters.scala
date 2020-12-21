package Filters

import Grids.GreyscaleGrid

trait Filter{
  def applyFilter(greyColorGrid: GreyscaleGrid): GreyscaleGrid
}

/**
 * Filter inverts greyscale value
 * */
class InvertFilter() extends Filter {
  override def applyFilter(greyscaleGrid: GreyscaleGrid): GreyscaleGrid = {
    val greyscaleAfterFilter = Array.ofDim[Int](greyscaleGrid.getHeight, greyscaleGrid.getWidth)

    for {
      h1 <- (0 until greyscaleGrid.getWidth)
      w1 <- (0 until greyscaleGrid.getWidth)
    } yield {
      greyscaleAfterFilter(h1)(w1) = 255 - greyscaleGrid.getValue(h1, w1)
    }
    new GreyscaleGrid(greyscaleGrid.getHeight, greyscaleGrid.getWidth, greyscaleAfterFilter)
  }
}

/**
 * Filter adds brightness to greyscale values
 * */
class BrightnessFilter(brightness: String) extends Filter {
require(brightness.toInt.isValidInt)

  def checkOverflow(value: Int): Int = if (value < 0) 0 else if(value > 255) 255 else value

  override def applyFilter(greyscaleGrid: GreyscaleGrid): GreyscaleGrid = {
    val greyscaleAfterFilter = Array.ofDim[Int](greyscaleGrid.getHeight, greyscaleGrid.getWidth)

    val brightnessValue = brightness.toInt
    for {
      h1 <- (0 until greyscaleGrid.getHeight)
      w1 <- (0 until greyscaleGrid.getWidth)
    } yield {
      greyscaleAfterFilter(h1)(w1) = checkOverflow(greyscaleGrid.getValue(h1, w1) + brightnessValue)
    }
    new GreyscaleGrid(greyscaleGrid.getHeight, greyscaleGrid.getWidth, greyscaleAfterFilter)
  }
}

/**
 * Filter flips greyscale grid on X/Y axes
 * */
class FlipFilter(axis: String) extends Filter {
  require(axis.toUpperCase == "Y" || axis.toUpperCase == "X")

  override def applyFilter(greyColorGrid: GreyscaleGrid): GreyscaleGrid = {
    if(axis.toUpperCase == "Y")
      flipVertically(greyColorGrid)
    else
      flipHorizontally(greyColorGrid)
  }

  def flipHorizontally(greyscaleGrid: GreyscaleGrid): GreyscaleGrid ={
    val greyscaleAfterFilter = greyscaleGrid.getGrid

    for{
      y <- 0 until greyscaleGrid.getWidth
      x <- 0 until greyscaleGrid.getHeight/2
    }yield{
      val tmpChar = greyscaleGrid.getValue(greyscaleGrid.getHeight-x-1, y)
      greyscaleAfterFilter(greyscaleGrid.getHeight-x-1)(y) = greyscaleGrid.getValue(x, y)
      greyscaleAfterFilter(x)(y) = tmpChar
    }

    new GreyscaleGrid(greyscaleGrid.getHeight, greyscaleGrid.getWidth, greyscaleAfterFilter)
  }
  def flipVertically(greyscaleGrid: GreyscaleGrid): GreyscaleGrid ={
    val greyscaleAfterFilter = greyscaleGrid.getGrid

    for{
      x <- 0 until greyscaleGrid.getHeight
      y <- 0 until greyscaleGrid.getWidth/2
    }yield{
      val tmpChar = greyscaleGrid.getValue(x, greyscaleGrid.getWidth - y - 1)
      greyscaleAfterFilter(x)(greyscaleGrid.getWidth - y - 1) = greyscaleGrid.getValue(x, y)
      greyscaleAfterFilter(x)(y) = tmpChar
    }

    new GreyscaleGrid(greyscaleGrid.getHeight, greyscaleGrid.getWidth, greyscaleAfterFilter)
  }
}
