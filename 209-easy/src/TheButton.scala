import scala.io.Source

object TheButton extends App {
  Source.fromFile(args(0)).getLines().drop(1).toList
    .map(_.split(": ")).map(a => a(0) -> a(1).toDouble).sortBy(_._2)
    .foldLeft[Double](0) { case (b, (n, v)) =>
      println(s"$n: ${Math.floor(60 + b - v)}")
      v
  }
}
