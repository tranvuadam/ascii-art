package Grids

class AsciiGrid(val width: Int, val height: Int, val asciiChars: Array[Array[Char]]){
  require(asciiChars.length * asciiChars.head.length == width * height)
}
