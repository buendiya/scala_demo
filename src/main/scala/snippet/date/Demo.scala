package snippet.date

import java.util.{Date, Locale}
import java.text.DateFormat._
import java.util.Date
import java.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.time.LocalDate

object Demo{

  def main(args: Array[String]): Unit = {
    val dat = LocalDate.parse("2017-05-17")
    val formattedDate = DateTimeFormatter.ofPattern("yyyyMMdd");
    (0 until 5).map(dat.plusDays(_)).foreach((date) => println(date.format(formattedDate)))
  }
}




