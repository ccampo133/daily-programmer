import scala.io.StdIn

object Rovarspraket extends App {
  val input = StdIn.readLine()
  val vowels = Set('A', 'E', 'I', 'O', 'U', 'Y', 'Å', 'Ä', 'Ö')
  println(s"Encoded: ${encode(input)}")
  println(s"Decoded: ${decode(input)}")

  def isConsonant(c: Char) = Character.isLetter(c) && !vowels.contains(c.toUpper)

  def encode(s: String) = s.map(c => if (isConsonant(c)) c + "o" + c.toLower else c.toString).mkString

  def decode(s: String): String = {
    if (s.length == 0) return ""
    if (isConsonant(s(0))) s(0) + decode(s.drop(3))
    else s(0) + decode(s.tail)
  }

  def decodeTail(s: String): String = {
    @annotation.tailrec
    def decodeTail(s: String, acc: String): String = {
      if (s.length == 0) return acc
      if (isConsonant(s(0))) decodeTail(s.drop(3), acc + s(0))
      else decodeTail(s.tail, acc + s(0))
    }
    decodeTail(s, "")
  }

}
