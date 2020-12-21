package InputHandler

import java.awt.image.BufferedImage

/**
 * InputController extracts extension from path and checks if extension is supported and returns appropriate ImageHandler
 * */
object InputController{
  /**
   * Method to get extension (last substring of path starting with ".")
   * */
  def getExtension(path: String): String ={
    var extension = ""
    val i = path.lastIndexOf('.')
    if (i >= 0) extension = path.substring(i + 1)
    extension
  }

  def apply(path: String): BufferedImage = {
    val extension = getExtension(path)
    val imageHandler = extension.toUpperCase match {
      case "JPG" => new JPEGHandler
      case "PNG" => new PNGHandler
      case _ => throw new IllegalArgumentException("Unsupported file format.")
    }
    imageHandler.load(path)
  }
}
