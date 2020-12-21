package Converter

import Grids.{AsciiGrid, GreyscaleGrid}

/**
 * AsciiConverter converts greyscale values into their ascii value and returns an Ascii grid.
 * */
object AsciiConverter {
  val asciiTable = " .,:;ox%#@"

  def getAsciiValue(original_value : Int): Char ={
    var value = original_value
    if (original_value > 255)
      value = 255
    else if(original_value < 0)
      value = 0
    asciiTable.charAt((255-value)*10/256)
  }

  def apply(greyscaleGrid: GreyscaleGrid): AsciiGrid = {
    val asciiArray = Array.ofDim[Char](greyscaleGrid.getHeight, greyscaleGrid.getWidth)
    for {
      h1 <- (0 until greyscaleGrid.getHeight)
      w1 <- (0 until greyscaleGrid.getWidth)
    } yield {
      asciiArray(h1)(w1) = getAsciiValue(greyscaleGrid.getValue(h1, w1))
    }
    new AsciiGrid(greyscaleGrid.getHeight, greyscaleGrid.getWidth, asciiArray)
  }

}

