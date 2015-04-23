import scala.annotation.tailrec
import scala.io.Source

object OgreMaze extends App {
  val grid = Source.fromFile(args(0)).getLines().toArray.map(_.toCharArray)
  val (x0, y0) = findStart()
  getPath(x0, y0) match {
    case Some(path) => printPath(path)
    case None => println("NO PATH")
  }

  def findStart(): (Int, Int) = {
    @tailrec
    def find(row: Int, col: Int): (Int, Int) = {
      if (row == grid.length) (-1, -1)
      else if (col == grid(row).length) find(row + 1, 0)
      else if (grid(row)(col) == '@') (row, col)
      else find(row, col + 1)
    }
    find(0, 0)
  }

  def getPath(x0: Int, y0: Int): Option[List[(Int, Int)]] = {
    var path = List[(Int, Int)]()
    var visited = Set[(Int, Int)]()

    def search(x: Int, y: Int): Boolean = {
      visited += (x -> y)
      var solved = false
      if (found(x, y, '$')) {
        solved = true
      } else {
        if (isInbounds(x + 1, y) && !visited.contains((x + 1, y)) && !found(x + 1, y, 'O'))
          solved = search(x + 1, y)
        if (isInbounds(x - 1, y) && !visited.contains((x - 1, y)) && !found(x - 1, y, 'O') && !solved)
          solved = search(x - 1, y)
        if (isInbounds(x, y + 1) && !visited.contains((x, y + 1)) && !found(x, y + 1, 'O') && !solved)
          solved = search(x, y + 1)
        if (isInbounds(x, y - 1) && !visited.contains((x, y - 1)) && !found(x, y - 1, 'O') && !solved)
          solved = search(x, y - 1)
      }

      if (solved) path = (x, y) :: path
      solved
    }

    if (search(x0, y0)) Some(path) else None
  }

  def isInbounds(x: Int, y: Int) = x >= 0 && x + 1 < grid(0).length && y >= 0 && y + 1 < grid.length

  def found(x: Int, y: Int, c: Char) = {
    grid(y)(x) == c || grid(y)(x + 1) == c || grid(y + 1)(x) == c || grid(y + 1)(x + 1) == c
  }

  def printPath(path: List[(Int, Int)]): Unit = {
    path.foreach { case (x, y) =>
      grid(y)(x) = '&'
      grid(y)(x + 1) = '&'
      grid(y + 1)(x) = '&'
      grid(y + 1)(x + 1) = '&'
    }
    grid.map(_.mkString).foreach(println)
  }
}
