package InputHandler

import java.awt.image.BufferedImage
import java.io.File

import javax.imageio.ImageIO
//trait for loading more exotic input types
trait InputHandler{
  def load(path: String): Any
}
/**
 * InputFileHandler loads image from a file specified in parameter path
 * */
trait ImageHandler extends InputHandler{
  override def load(path: String): BufferedImage = {
    ImageIO.read(new File(path))
  }
}

class JPEGHandler extends ImageHandler {
}

class PNGHandler extends ImageHandler {
}
