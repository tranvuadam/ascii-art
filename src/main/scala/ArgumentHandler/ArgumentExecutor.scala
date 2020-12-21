package ArgumentHandler

import InputHandler.InputController
import Filters.{Filter, FilterController}
import outputHandler.{OutputController, OutputStream}

/**
 * ArgumentExecutor executes loads image, applies filters, and puts result into output streams
 * */
class ArgumentExecutor(path: String, outStreams: Seq[OutputStream], filters: Seq[Filter]){

  def execute(): Unit = {
    val image = InputController(path)

    var greyColorGrid = Converter.ImageConverter(image)

    greyColorGrid = FilterController(filters, greyColorGrid)

    val asciiGrid = Converter.AsciiConverter(greyColorGrid)
    OutputController(outStreams, asciiGrid)
  }
}
