import scala.io.StdIn

object NumberCuller extends App {
  val numbers = StdIn.readLine().filter(_ != ' ').toSet
  numbers foreach print
}
