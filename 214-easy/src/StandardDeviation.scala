import scala.io.StdIn

object StandardDeviation extends App {
  val sample = StdIn.readLine().split(" ").map(_.toDouble)
  val mean = sample.sum / sample.length
  val variance = sample.map(x => math pow(x - mean, 2)).sum / sample.length
  val std = math sqrt variance
  print(BigDecimal(std).setScale(4, BigDecimal.RoundingMode.HALF_UP))
}
