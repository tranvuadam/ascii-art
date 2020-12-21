package InputHandler

import javax.imageio.IIOException
import org.scalatest.FunSuite

class ImageHandlersTest extends FunSuite{
  test("File does not exist - jpg") {
    assertThrows[IIOException]{
      val handler = new JPEGHandler()
      handler.load("this_file_does_not_exist")
    }
  }
  test("File does not exist - png") {
    assertThrows[IIOException]{
      val handler = new PNGHandler()
      handler.load("this_file_does_not_exist")
    }
  }
}
