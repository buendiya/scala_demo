package snippet.retry

object Retry {

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

  def main(args: Array[String]): Unit = {
    val start = System.currentTimeMillis()
    try {
      //      fun(1)
      val l = 1 to 10
      l.foreach(fun)

    } catch {
      case e:Exception => println("it takes ", System.currentTimeMillis() - start)
    }

  }

}
