package ArgumentHandler;

import org.scalatest.FunSuite;

class ArgumentControllerTest extends FunSuite {
  test("Missing path"){
    val stringArray: Array[String] = Array("--image", "brightness", "+100" )
    assertThrows[IllegalArgumentException]{
      val argumentIterator = new ArgumentIterator(stringArray.iterator)
      ArgumentController(argumentIterator)
    }
  }
  test("No input file specified"){
    val stringArray: Array[String] = Array("brightness", "+100", "--output-console" )
    assertThrows[IllegalArgumentException]{
      val argumentIterator = new ArgumentIterator(stringArray.iterator)
      ArgumentController(argumentIterator)
    }
  }
  test("No output streams specified"){
    val stringArray: Array[String] = Array("--image", "some_path/image.gif", "brightness", "+100" )
    assertThrows[IllegalArgumentException]{
      val argumentIterator = new ArgumentIterator(stringArray.iterator)
      ArgumentController(argumentIterator)
    }
  }
  test("Missing arguments"){
    val stringArray: Array[String] = Array("--image")
    assertThrows[IllegalArgumentException]{
      val argumentIterator = new ArgumentIterator(stringArray.iterator)
      ArgumentController(argumentIterator)
    }
  }
}
