package Grids

/**
 *Data model to hold greyscale values
 * */
class GreyscaleGrid(private val height: Int, private val width: Int, private val greyValues: Array[Array[Int]]) extends Grid{
  require(greyValues.length * greyValues.head.length == width * height)

  override def getValue(y: Int, x: Int): Int = {
    require(x < width && x >= 0 && y < height && y >= 0)
    greyValues(y)(x)
  }
  override def getHeight: Int = height
  override def getWidth: Int = width

  override def getGrid: Array[Array[Int]] = greyValues
}
