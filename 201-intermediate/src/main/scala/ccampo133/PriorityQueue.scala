package ccampo133

class PriorityQueue[T] {
  var items = Seq.empty[(T, Double, Double)]

  def count: Int = items.length
  def clear(): Unit = items = Seq.empty[(T, Double, Double)]
  def enqueue(item: T, priA: Double, priB: Double): Unit = items :+=(item, priA, priB)

  def dequeueA: T = {
    // Reversing the sign sorts in descending order
    val item = items.sortBy(-_._2).head._1
    items = items filter (_._1 != item)
    item
  }

  def dequeueB: T = {
    val item = items.sortBy(-_._3).head._1
    items = items filter (_._1 != item)
    item
  }

  def dequeueFirst: T = {
    val item = items(0)._1
    items = items filter(_._1 != item)
    item
  }
}
