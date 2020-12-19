package InputHandler

import Main.ArgumentController

object InputController{

  def getExtension(path: String): String ={
    var extension = ""
    val i = path.lastIndexOf('.')
    if (i >= 0) extension = path.substring(i + 1)
    extension
  }

  def apply(arguments_controller: ArgumentController): InputImageHandler =  {
    if(arguments_controller.getNextArgument == "--image"){
      val path = arguments_controller.getNextArgument
      val extension = getExtension(path)
      val handler = extension.toUpperCase match {
        case "JPG" => new JPEGHandler
        case "PNG" => new PNGHandler
        case _ => throw new IllegalArgumentException("Invalid file format.")
      }
      handler.setPath(path)
      handler
    }else
      throw new IllegalArgumentException("Incorrect arguments.")
  }
}
