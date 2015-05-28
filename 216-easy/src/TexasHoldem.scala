import scala.collection.mutable
import scala.io.StdIn
import scala.util.Random

/**
 * @author Chris Campo
 */
object TexasHoldem extends App {

  case class Card(suit: String, value: String)

  case class Hand(card1: Card, card2: Card)

  val suits = Seq("Clubs", "Diamonds", "Hearts", "Spades")
  val values = Seq("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")
  val deck = mutable.Stack(Random.shuffle(for (suit <- suits; value <- values) yield Card(suit, value)): _*)

  print("How many players (2-8) ? ")
  val nPlayers = StdIn.readInt()
  val hands = 0 to nPlayers map (_ => Hand(deck.pop(), deck.pop()))

  // Burn and draw the flop
  deck.pop()
  val flop = 0 to 3 map (_ => deck.pop())

  // Burn and draw the turn
  deck.pop()
  val turn = deck.pop()

  // Burn and draw the river
  deck.pop()
  val river = deck.pop()

  // Print the hands
  hands.zipWithIndex foreach { case (hand, i) =>
    println(s"Player ${i + 1}: ${cardString(hand.card1)}, ${cardString(hand.card2)}")
  }

  // Print the game
  println(s"Flop: ${flop map cardString mkString ", "}")
  println(s"Turn: ${cardString(turn)}")
  println(s"River: ${cardString(river)}")

  def cardString(card: Card) = s"${card.value} of ${card.suit}"
}
