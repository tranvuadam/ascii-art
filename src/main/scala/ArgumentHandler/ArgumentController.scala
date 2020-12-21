package ArgumentHandler

import Filters.{BrightnessFilter, Filter, FlipFilter, InvertFilter}
import outputHandler.{ConsoleStream, FileStream, OutputStream}

/**
 * ArgumentController parses console arguments and puts them in their respective Sequence
 */
object ArgumentController{
  def apply(argumentIterator: ArgumentIterator): ArgumentExecutor =  {
    var filters: Seq[Filter] = Seq.empty[Filter]
    var outStreams: Seq[OutputStream] = Seq.empty[OutputStream]
    var filePath = ""

    while(argumentIterator.hasNextArgument){
      argumentIterator.getNextArgument.toUpperCase match {
        // two arguments
        case "--IMAGE" => filePath = argumentIterator.getNextArgument
        case "--OUTPUT-FILE" => outStreams = outStreams :+ new FileStream(argumentIterator.getNextArgument)
        case "--BRIGHTNESS" => filters = filters :+ new BrightnessFilter(argumentIterator.getNextArgument)
        case "--FLIP" => filters = filters :+ new FlipFilter(argumentIterator.getNextArgument)
        // one argument
        case "--OUTPUT-CONSOLE" => outStreams = outStreams :+ new ConsoleStream
        case "--INVERT" =>  filters = filters :+ new InvertFilter
        case _ => throw new IllegalArgumentException("Invalid argument option.")
      }
    }
    new ArgumentExecutor(filePath, outStreams, filters)
  }
}


