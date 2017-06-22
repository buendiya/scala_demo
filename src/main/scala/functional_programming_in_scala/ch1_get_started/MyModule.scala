package functional_programming_in_scala.ch1_get_started

/**
  * Created by jingsz on 6/8/17.
  */
class MyModule {}

object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

//  def fun() = "hello"

  def main(args: Array[String]): Unit =
    println(formatAbs(-42))
}

object Test {

  def main(args: Array[String]): Unit = {
    println(MyModule.abs(-42))
    println(MyModule abs -42)

//    println(MyModule.fun())
//    println(MyModule fun)
  }
}
