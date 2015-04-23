import scala.io.Source

object OgreMaze extends App {
  val grid = Source.fromFile(args(0)).getLines().toArray.map(_.toCharArray)
  val (w, h) = (grid(0).length, grid.length)
  search(0, 0) match {
    case Some(path) => printPath(path)
    case None => println("NO PATH")
  }

  def search(x0: Int, y0: Int): Option[List[(Int, Int)]] = {
    var visited = Set[(Int, Int)]()
    var stack = List[(Int, Int)]()

    stack = (x0, y0) :: stack // Push
    while (stack.nonEmpty) {
      println(stack)
      // Pop
      val (x, y) = stack.head match {
        case (a, b) => (a, b)
      }
      stack = stack.tail

      if (found(x, y, '$')) return Some((x, y) :: stack)

      if (!visited.contains((x, y))) {
        visited += (x -> y)
        if (isInbounds(x + 1, y) && !found(x + 1, y, 'O'))
          stack = (x + 1, y) :: stack
        if (isInbounds(x - 1, y) && !found(x - 1, y, 'O'))
          stack = (x - 1, y) :: stack
        if (isInbounds(x, y + 1) && !found(x, y + 1, 'O'))
          stack = (x, y + 1) :: stack
        if (isInbounds(x, y - 1) && !found(x, y - 1, 'O'))
          stack = (x, y - 1) :: stack
      }
    }

    // We've walked the entire graph at this point.
    None
  }

  def isInbounds(x: Int, y: Int) = x >= 0 && x + 1 < w && y >= 0 && y + 1 < h

  def found(x: Int, y: Int, c: Char) = {
    grid(y)(x) == c || grid(y)(x + 1) == c || grid(y + 1)(x) == c || grid(y + 1)(x + 1) == c
  }

  def printPath(points: List[(Int, Int)]): Unit = {
    println(points)
    var pts = points

    while (pts.nonEmpty) {
      // Pop
      val (x, y) = pts.head match {
        case (a, b) => (a, b)
      }
      println(x, y)
      pts = pts.tail
      grid(y)(x) = '&'
      grid(y)(x + 1) = '&'
      grid(y + 1)(x) = '&'
      grid(y + 1)(x + 1) = '&'
    }

    grid.map(_.mkString).foreach(println)
  }
}
