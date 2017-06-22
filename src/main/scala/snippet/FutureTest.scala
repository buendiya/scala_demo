/*
http://stackoverflow.com/questions/28160021/using-futures-and-thread-sleep
 */
package src.snippet

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object ScalaFuture {

  def main(args: Array[String]) {

    val f: Future[String] = Future {
      Thread.sleep(2000)
      "future value"
    }

    val f2 = f map { s =>
      println("OK!")
      println("OK!")

    }

    f.onSuccess {
      case s => {
        Console.println("Console.println OK!")
        System.out.println("System.out.println OK!")
      }
    }

    def test = {
      Await.ready(f, 60 seconds)
      println("exit")
    }

    def test2 = {
      Await.ready(f2, 60 seconds)
      println("exit")
    }

    test2
  }

}
