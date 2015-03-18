import scala.io.StdIn

object RecurrenceRelations extends App {
  val formula = StdIn.readLine()
  val base = StdIn.readDouble()
  val term = StdIn.readInt()
  val result = ntimes(term, recurrence, base)

  def recurrence(base: Double): Double = {
    formula.split(" ")
      .foldLeft(base)((b, term) => op(term.charAt(0), term.substring(1).toDouble, b))
  }

  def ntimes(n: Int, f: Double => Double, base: Double): Double = {
    println(s"Term ${term - n}: $base")
    if (n == 0) base
    else ntimes(n - 1, f, f(base))
  }

  def op(s: Char, x: Double, base: Double): Double = s match {
    case '+' => base + x
    case '-' => base - x
    case '*' => base * x
    case '/' => base / x
  }
}
