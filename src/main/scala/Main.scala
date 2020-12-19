package Main

import Converter.{AsciiConverter, ImageConverter}
import Filters.FilterController
import InputHandler.InputController
import outputHandler.OutputController

class ArgumentController(arguments_iterator: Iterator[String]){
  def getNextArgument: String = {
    if(!arguments_iterator.hasNext) {
      println("Missing an argument.")
      sys.exit(1)
    }
    arguments_iterator.next()
  }
  def hasNextArgument: Boolean = {
    arguments_iterator.hasNext
  }
}

object Main extends App {
  val argumentController = new ArgumentController(args.iterator)
  val inputHandler = InputController(argumentController)
  val loaded_image = inputHandler.loadImage()
  val greyColorGrid = ImageConverter.convertImageToGreyColor(loaded_image)
  //apply filters
  val greyGridAfterFilters = FilterController(argumentController, greyColorGrid)
  val asciiGrid = AsciiConverter.convertGreyColorsToAscii(greyGridAfterFilters)
  OutputController(argumentController, asciiGrid)
}