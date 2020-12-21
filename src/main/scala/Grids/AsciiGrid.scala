package Grids

/**
 * Data model to hold ascii values
 * */
class AsciiGrid(private val height: Int, private val width: Int, private val asciiChars: Array[Array[Char]]) extends Grid {
  require(asciiChars.length * asciiChars.head.length == width * height)

  override def getValue(y: Int, x: Int): Char = {
    require(x < width && x >= 0 && y < height && y >= 0)
    asciiChars(y)(x)
  }
  override def getHeight: Int = height
  override def getWidth: Int = width
  override def getGrid: Array[Array[Char]] = asciiChars

}
