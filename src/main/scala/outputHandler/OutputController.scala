package outputHandler

import Grids.AsciiGrid
import Main.ArgumentController

object OutputController {
  def apply(arguments_controller: ArgumentController, asciiGrid: AsciiGrid): Unit =  {
    while (arguments_controller.hasNextArgument){
      val output_argument:String = arguments_controller.getNextArgument
      val outputHandler = output_argument.toUpperCase match {
        case "--OUTPUT-FILE" => new FileHandler(arguments_controller.getNextArgument)
        case "--OUTPUT-CONSOLE" => new ConsoleHandler()
        case _ => throw new IllegalArgumentException("Invalid output option.")
      }
      outputHandler.write(asciiGrid)
    }
  }
}
