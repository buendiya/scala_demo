
import java.util.{Date, Locale}
import java.text.DateFormat._
import scala.util.Try

object Main {

  def fun[A](a: A): Option[A] = Some(a)

  def apply[A](x: A): Option[A] = if (x == null) None else Some(x)

  def IntOps(f: Int => Int)(values: List[Int]): Int = {
    if(values.isEmpty) 0
    //Getting "Application does not take parameters" in values.tail
    else IntOps(f)(values.tail)
  }

  def streamDemo = {
    val s = Stream.empty[Int]
    def f = (s: Stream[Int], a: Int) => Stream.cons[Int]({println(s"hi ${a}"); a}, s)
    val s2 = (1 to 5).toList.foldLeft(s)(f)
    s2.map(println(_))
//    println(s2.exists(_<20))
  }

  def main(args: Array[String]): Unit = {
    streamDemo

  }
}



