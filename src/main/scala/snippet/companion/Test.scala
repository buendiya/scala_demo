package snippet.companion


object Test {
  val y = 2
  def fun(x: Int): Unit = println(x)
}

class Test


object Main {
  def main(args: Array[String]): Unit = {
    val t = Test
    t.fun(2)
    t fun 2

    val t2 = new Test
    // below not working
//    t2.fun(2)

  }
}


