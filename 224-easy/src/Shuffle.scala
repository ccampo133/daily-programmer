import scala.util.Random

class Shuffle {

  val r = Random

  def fisherYates[T](seq: Seq[T]): Seq[T] = {
    def shuffle(elems: Seq[T], i: Int): Seq[T] = {
      if (i == 1) elems
      else shuffle(swap(elems, i, r.nextInt(seq.size)), i - 1)
    }
    def swap(elems: Seq[T], i: Int, j: Int): Seq[T] = {
      val t = elems(i)
      elems.updated(i, elems(j)).updated(j, t)
    }
    shuffle(seq, seq.size - 1)
  }

  def faroShuffle[T](seq: Seq[T]): Seq[T] = {
    val n = seq.length / 2
    val zipped = seq.take(n) zip seq.drop(n) flatMap (x => Seq(x._1, x._2))
    if (seq.length % 2 == 0) zipped else zipped :+ seq.last
  }

  def faroShuffleNTimes[T](seq: Seq[T], n: Int): Seq[T] = {
    if (n == 0) seq
    else faroShuffleNTimes(faroShuffle(seq), n - 1)
  }
}
