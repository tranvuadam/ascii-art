package Grids
import org.scalatest.FunSuite

class GreyscaleGridTest extends FunSuite{
  test("Incorrect width and height"){
    assertThrows[IllegalArgumentException]{
      new GreyscaleGrid(1, 1, Array(Array(1, 1), Array(1, 1)))
    }
  }
  test("Getting value out of bounds x"){
    assertThrows[IllegalArgumentException]{
      val grid = new GreyscaleGrid(3, 2, Array(Array(1, 1), Array(1, 1), Array(1, 1)))
      grid.getValue(3, 1)
    }
  }
  test("Getting value out of bounds y"){
    assertThrows[IllegalArgumentException]{
      val grid = new GreyscaleGrid(3, 2, Array(Array(1, 1), Array(1, 1), Array(1, 1)))
      grid.getValue(0, 2)
    }
  }
}