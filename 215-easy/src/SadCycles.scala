import scala.io.StdIn

object SadCycles extends App {

  def sad(n: Int)(x: Int): Int = (x.toString map (c => math pow(c.asDigit, n))).sum.toInt

  def findCycle(f: Int => Int, x0: Int): Stream[Int] = {
    @annotation.tailrec
    def floyd(t: Int, h: Int): Int = {
      val tortoise = f(t)
      val hare = f(f(h))
      if (tortoise == hare) tortoise
      else floyd(tortoise, hare)
    }

    val end = floyd(x0, x0)
    lazy val cycle: Stream[Int] = end #:: cycle map f
    (cycle takeWhile (_ != end)) :+ end
  }

  val n = StdIn.readInt()
  val x = StdIn.readInt()
  print(findCycle(sad(n), x) mkString ", ")
}
