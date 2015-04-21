import scala.io.StdIn

object NameGame extends App {
  val name = StdIn.readLine()
  println(
    s"""$name, $name bo-${rhyme('b', name)},
       |Bonana fanna fo-${rhyme('f', name)},
       |Fee fy mo-${rhyme('m', name)},
       |$name!""".stripMargin)

  def rhyme(letter: Char, name: String): String = {
    val firstChar = name.charAt(0).toLower
    if (Set('a', 'e', 'i', 'o', 'u').contains(firstChar))
      letter.toLower + name.toLowerCase
    else if (firstChar == letter.toLower)
      name.substring(1).toLowerCase
    else
      letter.toLower + name.substring(1).toLowerCase
  }
}
