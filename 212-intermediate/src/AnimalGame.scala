import scala.annotation.tailrec
import scala.io.StdIn

object AnimalGame {

  sealed abstract class Tree

  case class Node(value: String, left: Tree, right: Tree) extends Tree

  case class Leaf(value: String) extends Tree

  def main(args: Array[String]) {
    val tree = Node("Is your animal a mammal?", Leaf("dog"), Leaf("fish"))
    play(tree)
    println("Thanks for playing! Goodbye!")
  }

  @tailrec
  def play(tree: Tree): Unit = {
    val newTree = traverseTree(tree)
    println("Shall we play again?")
    val again = StdIn.readLine().toLowerCase
    if (again == "yes" || again == "y") play(newTree)
  }

  def traverseTree(tree: Tree): Tree = tree match {
    case Leaf(animal) =>
      println(s"Is your animal a $animal?")
      StdIn.readLine().toLowerCase match {
        case "y" | "yes" =>
          println("Hooray! I guessed correctly!")
          tree
        case _ => newAnimal(animal)
      }

    case Node(question, yes, no) =>
      println(question)
      StdIn.readLine().toLowerCase match {
        case "y" | "yes" => Node(question, traverseTree(yes), no)
        case _ => Node(question, yes, traverseTree(no))
      }
  }

  def newAnimal(oldAnimal: String): Tree = {
    println("I give up! What is your animal?")
    val animal = StdIn.readLine()
    println("Please enter a question that would answer \"yes\" for your animal.")
    val question = StdIn.readLine()
    Node(question, Leaf(animal), Leaf(oldAnimal))
  }
}
