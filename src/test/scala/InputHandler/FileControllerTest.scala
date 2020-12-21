package InputHandler

import org.scalatest.FunSuite

class FileControllerTest extends FunSuite{
  test("Unsupported file extension"){
    assertThrows[IllegalArgumentException]{
      InputController("some_path.gif")
    }
  }
  test("No extension"){
    assertThrows[IllegalArgumentException]{
      InputController("some_path")
    }
  }
}
