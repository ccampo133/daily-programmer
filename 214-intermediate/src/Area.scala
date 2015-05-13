import scala.io.Source

object Area extends App {
  val lines = Source.fromFile(args(0)).getLines()
  val Array(w, h) = lines.next() split " " map (_.toInt)
  val grid = Array.ofDim[Int](h, w)

  // Build up the grid
  var colors = Set[Int](0)
  for (line <- lines) {
    val Array(c, x, y, w0, h0) = line split " " map (_.toInt)
    colors = colors + c
    for {
      i <- y until (y + h0)
      j <- x until (x + w0)
    } grid(i)(j) = c
  }

  // Compute the areas
  for (c <- colors.toList.sorted) {
    val area = (grid map (a => a count (_ == c))).sum
    println(s"$c $area")
  }
}
