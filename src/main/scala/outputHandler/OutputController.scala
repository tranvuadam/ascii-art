package outputHandler

import Grids.AsciiGrid
/**
 * OutputController writes an ascii grid to loaded output streams
 * */
object OutputController {
  def apply(outputStreams: Seq[OutputStream], asciiGrid: AsciiGrid): Unit =  {
    require(outputStreams.nonEmpty)
    for(outStream <- outputStreams)
      outStream.write(asciiGrid)
  }
}
