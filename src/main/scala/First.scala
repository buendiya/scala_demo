
import java.util.{Date, Locale}
import java.text.DateFormat._
import scala.util.Try
import scala.Function0
import java.util.Date
import java.time.format.DateTimeFormatter
import java.text.SimpleDateFormat
import java.time.LocalDate

object Main {

  @annotation.tailrec
  def retry[T](n: Int, sleepMillis: Int=1)(fn: => T): T = {
    util.Try { fn } match {
      case util.Success(x) => x
      case _ if n > 1 => Thread.sleep(sleepMillis); retry(n - 1, sleepMillis)(fn)
      case util.Failure(e) => throw e
    }
  }

  val fun = (i: Int) => {
    def wrapper() = {
      println("hello", i)
      if (i < 10)
        throw new Exception("test")
    }
    retry(3, 1000)(wrapper)
  }

  def fun2(i: Int=1): Int = {
    i
  }

  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    try {
      println(fun2())
      println(fun2(2))
//      fun(1)
      //    val l = 1 to 10
      //    l.foreach(fun)

    } catch {
      case e:Exception => println("it takes ", System.currentTimeMillis() - start)
    }

  }
}



