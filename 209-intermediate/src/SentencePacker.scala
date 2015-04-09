import scala.io.StdIn

object SentencePacker extends App {
  val s = StdIn.readLine().filter(_ != ' ')
  val l = (Math.sqrt(s.length).floor.toInt to s.length).find(s.length % _ == 0).getOrElse(s.length)
  println("1 1")
  s.grouped(l).zipWithIndex.foreach { case (grp, i) => if (i % 2 == 0) println(grp) else println(grp.reverse) }
}
