package Filters

import Grids.GreyscaleGrid
import org.scalatest.FunSuite

class FilterControllerTest extends FunSuite{
  test("No filters, greyscale grid remains unchanged."){

    val greyscaleGrid = new GreyscaleGrid(2, 2, Array(Array(1, 1), Array(1, 1)))
    val filters: Seq[Filter] = Seq.empty[Filter]

    val newGreyscaleGrid = FilterController(filters, greyscaleGrid)
    assert(greyscaleGrid == newGreyscaleGrid)
  }

}
