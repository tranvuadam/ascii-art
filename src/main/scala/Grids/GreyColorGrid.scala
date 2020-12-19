package Grids

class GreyColorGrid(val width: Int, val height: Int, val greyValues: Array[Array[Int]]){
  require(greyValues.length * greyValues.head.length == width * height)
}
