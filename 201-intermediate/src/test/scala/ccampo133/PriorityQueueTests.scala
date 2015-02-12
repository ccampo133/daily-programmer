package ccampo133

import org.scalatest.{BeforeAndAfter, FunSuite}

class PriorityQueueTests extends FunSuite with BeforeAndAfter {

  var q: PriorityQueue[String] = _

  before {
    q = new PriorityQueue[String]()
  }

  test("Enqueue") {
    q enqueue("foo", 0, 0)
    assert(q.count == 1)
  }

  test("DequeueA") {
    q enqueue("foo", 5, 10)
    q enqueue("bar", 1, 2)
    q enqueue("baz", 10, 7)
    val result = q.dequeueA
    assert(result == "baz")
    assert(q.count == 2)
  }

  test("DequeueB") {
    q enqueue("foo", 5, 10)
    q enqueue("bar", 1, 2)
    q enqueue("baz", 10, 7)
    val result = q.dequeueB
    assert(result == "foo")
    assert(q.count == 2)
  }

  test("DequeueFirst") {
    q enqueue("foo", 5, 10)
    q enqueue("bar", 1, 2)
    q enqueue("baz", 10, 7)
    val result = q.dequeueFirst
    assert(result == "foo")
    assert(q.count == 2)
  }

  test("Clear") {
    q.enqueue("foo", 0, 0)
    q.enqueue("bar", 0, 0)
    q.clear()
    assert(q.count == 0)
  }
}
