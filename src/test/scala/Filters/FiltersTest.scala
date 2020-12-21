package Filters

import Grids.GreyscaleGrid
import org.scalatest.FunSuite

class FiltersTest extends FunSuite{

  test("Invert filter"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 1), Array(10, 10))))
    val filter = new InvertFilter
    val gridAfterFilter = filter.applyFilter(greyscaleGrid)
    assert(gridAfterFilter.getValue(0, 0) == 254)
    assert(gridAfterFilter.getValue(1, 0) == 245)
    assert(gridAfterFilter.getValue(0, 1) == 254)
    assert(gridAfterFilter.getValue(1, 1) == 245)
  }
  test("Brightness filter incorrect value"){
    assertThrows[IllegalArgumentException]{
      val filter = new BrightnessFilter("abc")
    }
  }
  test("Brightness filter +Int format"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 1), Array(10, 10))))
    val filter = new BrightnessFilter("+15")
      val gridAfterFilter = filter.applyFilter(greyscaleGrid)
      assert(gridAfterFilter.getValue(0, 0) == 16)
      assert(gridAfterFilter.getValue(1, 0) == 25)
      assert(gridAfterFilter.getValue(0, 1) == 16)
      assert(gridAfterFilter.getValue(1, 1) == 25)
    }
  test("Brightness filter -Int format"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 1), Array(10, 10))))
    val filter = new BrightnessFilter("-5")
    val gridAfterFilter = filter.applyFilter(greyscaleGrid)
    assert(gridAfterFilter.getValue(0, 0) == 0)
    assert(gridAfterFilter.getValue(1, 0) == 5)
    assert(gridAfterFilter.getValue(0, 1) == 0)
    assert(gridAfterFilter.getValue(1, 1) == 5)
  }
  test("Brightness filter under 0 underflow test"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 1), Array(10, 10))))
    val filter = new BrightnessFilter("-10000")
    val gridAfterFilter = filter.applyFilter(greyscaleGrid)
    assert(gridAfterFilter.getValue(0, 0) == 0)
    assert(gridAfterFilter.getValue(1, 0) == 0)
    assert(gridAfterFilter.getValue(0, 1) == 0)
    assert(gridAfterFilter.getValue(1, 1) == 0)
  }
  test("Brightness filter over 255 overflow test"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 1), Array(10, 10))))
    val filter = new BrightnessFilter("10000")
    val gridAfterFilter = filter.applyFilter(greyscaleGrid)
    assert(gridAfterFilter.getValue(1, 0) == 255)
    assert(gridAfterFilter.getValue(0, 1) == 255)
    assert(gridAfterFilter.getValue(0, 0) == 255)
    assert(gridAfterFilter.getValue(1, 1) == 255)
  }

  test("Flip filter incorrect value"){
    assertThrows[IllegalArgumentException]{
      val filter = new FlipFilter("1")
    }
  }
  test("Flip filter horizontal"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 1), Array(10, 10))))
    val filter = new FlipFilter("X")
    val gridAfterFilter = filter.applyFilter(greyscaleGrid)
    assert(gridAfterFilter.getValue(0, 0) == 10)
    assert(gridAfterFilter.getValue(1, 0) == 1)
    assert(gridAfterFilter.getValue(0, 1) == 10)
    assert(gridAfterFilter.getValue(1, 1) == 1)
  }
  test("Flip filter vertical"){
    val greyscaleGrid = new GreyscaleGrid(2, 2, (Array(Array(1, 2), Array(10, 11))))
    val filter = new FlipFilter("Y")
    val gridAfterFilter = filter.applyFilter(greyscaleGrid)
    assert(gridAfterFilter.getValue(0, 0) == 2)
    assert(gridAfterFilter.getValue(1, 0) == 11)
    assert(gridAfterFilter.getValue(0, 1) == 1)
    assert(gridAfterFilter.getValue(1, 1) == 10)
  }

}
