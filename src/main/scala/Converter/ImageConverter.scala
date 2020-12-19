package Converter

import java.awt.image.BufferedImage

import Grids.GreyColorGrid

object ImageConverter{

  def pixels2Gray(R: Int, G: Int, B: Int): Int = (0.299 * R + 0.587 * G + 0.114 * B).toInt

  def convertImageToGreyColor(testImage: BufferedImage): GreyColorGrid = {
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
    new GreyColorGrid(width, height, pixels)
  }
}
