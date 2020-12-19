package InputHandler

import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO

trait InputImageHandler{
  private var path: String = ""

  def loadImage(path: String = path): BufferedImage = {
    println(path)
    ImageIO.read(new File(path))
  }
  def setPath(path: String): Unit = {this.path = path}
}

class JPEGHandler extends InputImageHandler {
}

class PNGHandler extends InputImageHandler{
}
