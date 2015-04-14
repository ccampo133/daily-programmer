import scala.io.StdIn

object IntHarmony extends App {
  val x = StdIn.readInt()
  val y = StdIn.readInt()
  val compatibility = 100 * countUnsetBits(x ^ y) / 32.0
  println(s"$compatibility% compatibility")
  println(s"$x should avoid ${complement(~x)}")
  println(s"$y should avoid ${complement(~y)}")

  def countUnsetBits(n: Int) = {
    (0 to 31).foldLeft[Int](0)((c, i) => {
      if (((n >>> i) & 1) == 0) c + 1
      else c
    })
  }

  def complement(n: Int) = n & 0xFFFFFFFFL
}
