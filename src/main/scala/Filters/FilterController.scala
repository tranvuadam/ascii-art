package Filters

import Grids.GreyColorGrid
import Main.ArgumentController

object FilterController{
  def apply(arguments_controller: ArgumentController, greyColorGrid: GreyColorGrid): GreyColorGrid =  {
    var newGreyColorGrid = greyColorGrid
    while(arguments_controller.hasNextArgument){
      val output_argument = arguments_controller.getNextArgument
      println(output_argument)
      val filter = output_argument.toUpperCase match {
        case "--INVERT" => new InvertFilter()
        case "--FLIP" => new FlipFilter(arguments_controller.getNextArgument)
        case "--BRIGHTNESS" => new BrightnessFilter(arguments_controller.getNextArgument)
        case "OUTPUT:" => return newGreyColorGrid
        case _ => throw new IllegalArgumentException("Invalid filter option.")
      }
      newGreyColorGrid = filter.applyFilter(newGreyColorGrid)
    }
    newGreyColorGrid
  }
}
