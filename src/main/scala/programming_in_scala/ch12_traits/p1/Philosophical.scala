package src.programming_in_scala.ch12_traits.p1

trait Philosophical {
  def philosophize() = {
    println("I consume memory, therefore I am!")
  }
}

class Frog extends Philosophical {
  override def toString = "green"
}

object PhilosophicalTest extends App{

  val p = new Philosophical {}
  p.philosophize()

  val frog = new Frog
  frog.philosophize()

}
