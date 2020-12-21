package outputHandler
import java.io.{BufferedWriter, File, FileWriter}

import Grids.AsciiGrid

trait OutputStream{
  def write(asciiGrid: AsciiGrid)
}

/**
 * ConsoleStream prints ascii grid to console
 * */
class ConsoleStream extends OutputStream {
  override def write(asciiGrid: AsciiGrid): Unit = {
    asciiGrid.getGrid foreach { row => row foreach print; println }
  }
}

/**
 * FileStream prints ascii grid to a file
 * */
class FileStream(output_path: String) extends OutputStream{
  override def write(asciiGrid: AsciiGrid): Unit = {
    val file = new File(output_path)
    val bw = new BufferedWriter(new FileWriter(file))

    for (row <- 0 until asciiGrid.getHeight){
      bw.write(asciiGrid.getGrid(row))
      bw.write("\n")
    }
    bw.close()
  }
}
