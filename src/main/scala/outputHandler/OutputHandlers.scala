package outputHandler
import java.io.{BufferedWriter, File, FileWriter}

import Grids.AsciiGrid

trait OutputHandler{
  def write(asciiGrid: AsciiGrid)
}
class ConsoleHandler extends OutputHandler {
  override def write(asciiGrid: AsciiGrid): Unit = {
    asciiGrid.asciiChars foreach { row => row foreach print; println }
  }
}

class FileHandler(output_path: String) extends OutputHandler{
  override def write(asciiGrid: AsciiGrid): Unit = {
    val file = new File(output_path)
    val bw = new BufferedWriter(new FileWriter(file))

    for (row <- 0 until asciiGrid.height){
      bw.write(asciiGrid.asciiChars(row))
      bw.write("\n")
    }
    bw.close()
  }
}
