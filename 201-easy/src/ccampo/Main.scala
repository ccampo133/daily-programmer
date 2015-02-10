package ccampo

import java.text.SimpleDateFormat
import java.util.{Date, GregorianCalendar}

object Main {
  def main(args: Array[String]): Unit = {
    // Input: YYYY MM dd
    val Array(y, m, d) = args map(_.toInt)
    val d1 = new Date()
    val d2 = new GregorianCalendar(y, m - 1, d).getTime
    val diff = math.ceil((d2.getTime - d1.getTime).toDouble / (1000 * 60 * 60 * 24)).toInt
    val sdf = new SimpleDateFormat("YYYY-MM-dd")
    println(s"$diff days from ${sdf format d1} to ${sdf format d2}")
  }
}
