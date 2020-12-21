package Converter

import Grids.GreyscaleGrid
import org.scalatest.FunSuite

class AsciiConverterTest extends FunSuite{
  test("Ascii conversion darkest greyscale value"){
    val greyscaleGrid = new GreyscaleGrid(2, 1, Array(Array(1), Array(1)))
    val asciiGrid = AsciiConverter(greyscaleGrid)
    assert(asciiGrid.getValue(0, 0) == '@', asciiGrid.getValue(1, 0) == '@')
  }
  test("Ascii conversion greyscale value in middle"){
    val greyscaleGrid = new GreyscaleGrid(2, 1, Array(Array(130), Array(130)))
    val asciiGrid = AsciiConverter(greyscaleGrid)
    assert(asciiGrid.getValue(0, 0) == ';', asciiGrid.getValue(1, 0) == ';')
  }
  test("Ascii conversion lightest greyscale value"){
    val greyscaleGrid = new GreyscaleGrid(2, 1, Array(Array(255), Array(255)))
    val asciiGrid = AsciiConverter(greyscaleGrid)
    assert(asciiGrid.getValue(0, 0) == ' ', asciiGrid.getValue(1, 0) == ' ')
  }
}
