package ArgumentHandler

import org.scalatest.FunSuite

class ArgumentIteratorTest extends FunSuite{
  test("Empty arguments"){
    val stringArray: Array[String] = Array()
    assertThrows[IllegalArgumentException]{
      val argumentIterator = new ArgumentIterator(stringArray.iterator)
    }
  }
}
