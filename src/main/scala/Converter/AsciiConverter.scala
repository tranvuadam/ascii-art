package Converter

import Grids.{AsciiGrid, GreyColorGrid}

object AsciiConverter{
  val asciiTable = " .,:;ox%#@"

  def getAsciiValue(original_value : Int): Char ={
    var value = original_value
    if (original_value > 255)
      value = 255
    else if(original_value < 0)
      value = 0
    asciiTable.charAt((255-value)*10/256)
  }

  def convertGreyColorsToAscii(greyColorGrid: GreyColorGrid): AsciiGrid = {
    val asciiArray = Array.ofDim[Char](greyColorGrid.height, greyColorGrid.width)
    for {
      h1 <- (0 until greyColorGrid.height)
      w1 <- (0 until greyColorGrid.width)
    } yield {
      asciiArray(h1)(w1) = getAsciiValue(greyColorGrid.greyValues(h1)(w1))
    }
    new AsciiGrid(greyColorGrid.width, greyColorGrid.height, asciiArray)
  }

}

