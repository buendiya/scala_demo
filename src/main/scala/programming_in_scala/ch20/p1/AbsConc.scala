package src.programming_in_scala.ch20.p1

/**
  * Created by jingsz on 4/19/17.
  */
object AbsConc extends App{
  trait Abstract {
    type T
    def transform(x: T): T
    val initial: T
    var current: T
  }

  class Concrete extends Abstract {
    type T = String
    def transform(x: String) = x + x
    val initial = "hi"
    var current = initial
  }

  val a2 = new Concrete
}
