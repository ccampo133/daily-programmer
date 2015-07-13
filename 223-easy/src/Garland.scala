/**
 * @author Chris Campo
 */
object Garland {
  def garland(word: String): Int = word.indices.reverse.find(i => word.take(i) == word.takeRight(i)).getOrElse(0)
  def chain(n: Int, word: String): Unit = {
    1 to n - 1 foreach(_ => print(word.take(word.length - garland(word))))
    print(word)
  }
}
