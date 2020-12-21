package Main

object HelperText {
  def print(): Unit = {
    println("Ascii art converter usage: ")
    println("Supported file types: jpg, png")
    println("Input file: --image \"path_to_input_file\"")
    println("Filters: ")
    println("--invert ")
    println("--brightness \"integer_value\" ")
    println("--flip x")
    println("--flip y")
    println("Supported output streams: ")
    println("--output-console")
    println("--output-file \"path_to_output_directory\"")
  }
}
