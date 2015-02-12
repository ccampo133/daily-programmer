class PriorityQueue[T] {
  var items = Seq.empty[(T, Int, Int)]
  def enqueue(item: T, priA: Int, priB: Int): Unit = items :+= (item, priA, priB)
  def dequeueA: T = items.sortBy(t => t._2).head._1
  def dequeueB: T = items.sortBy(t => t._3).head._1
  def count: Int = items.length
  def clear(): Unit = items = Seq.empty[(T, Int, Int)]
}
