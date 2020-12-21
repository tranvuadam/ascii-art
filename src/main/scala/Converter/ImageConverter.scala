package Converter

import java.awt.image.BufferedImage

import Grids.GreyscaleGrid

/**
 * ImageConverter converts image pixel values into their greyscale value and returns a greyscale grid.
 * */
object ImageConverter{

  def pixels2Gray(R: Int, G: Int, B: Int): Int = (0.299 * R + 0.587 * G + 0.114 * B).toInt
  //to convert other types overload apply method
  def apply(testImage: BufferedImage): GreyscaleGrid = {
    val width = testImage.getWidth
    val height = testImage.getHeight

    val pixels = Array.ofDim[Int](height, width)
    for {
      h1 <- (0 until height)
      w1 <- (0 until width)
    } yield {
      val pixel = testImage.getRGB(w1, h1)
      val R = (pixel & 0xff0000) / 65536
      val G = (pixel & 0xff00) / 256
      val B = (pixel & 0xff)
      val grey_color = pixels2Gray(R, G, B)
      pixels(h1)(w1) = grey_color
    }
    new GreyscaleGrid(height, width, pixels)
  }

}
