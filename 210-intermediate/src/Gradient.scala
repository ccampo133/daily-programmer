import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

import scala.io.Source

object Gradient extends App {
  val lines = Source.fromFile(args(0)).getLines().toList
  val Array(w, h) = lines.head.split(" ").map(_.toInt)
  val Array(r0, g0, b0) = lines(1).split(" ").map(_.toInt)
  val Array(r1, g1, b1) = lines(2).split(" ").map(_.toInt)
  val img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)
  for (
    x <- 0 until w;
    y <- 0 until h
  ) img.setRGB(x, y, new Color(interp(x, r0, r1), interp(x, g0, g1), interp(x, b0, b1)).getRGB)
  ImageIO.write(img, "png", new File("gradient.png"))

  def interp(x: Int, y0: Int, y1: Int) = (y0 + (y1 - y0) * (x / w.toDouble)).toInt
}
