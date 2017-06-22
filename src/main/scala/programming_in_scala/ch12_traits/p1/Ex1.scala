package src.programming_in_scala.ch12_traits.p1

/**
  * Created by jingsz on 4/19/17.
  */
object Ex1 {
  class Animal

  class Frog extends Animal with Philosophical {
    override def toString = "green"
  }

  def main(args: Array[String]) {
    println("new Frog [" + (new Frog) + "]")
  }
}
