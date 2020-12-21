package outputHandler

import Grids.AsciiGrid
import org.scalatest.FunSuite

class OutputControllerTest extends FunSuite{
  test("No output streams"){
    val outStreams: Seq[OutputStream] = Seq.empty[OutputStream]
    assertThrows[IllegalArgumentException]{
      OutputController(outStreams, new AsciiGrid(2, 2, Array(Array(1,1), Array(1,1))))
    }
  }
}
