package src.programming_in_scala.ch19.InformationHiding


object Queues4 {
  // The private modifier between the class name and its parameters indicates that the constructor
  // of Queue is private
  class Queue[T] private (
                           private val leading: List[T],
                           private val trailing: List[T]
                         )
  {
    private def mirror =
      if (leading.isEmpty) new Queue(trailing.reverse, Nil)
      else this
    def head =
      mirror.leading.head
    def tail = {
      val q = mirror;
      new Queue(q.leading.tail, q.trailing)
    }
    def append(x: T) =
      new Queue(leading, x :: trailing)

    override def toString() =
      (leading ::: trailing.reverse) mkString ("Queue(", ", ", ")")
  }


  object Queue {
    // constructs a queue with initial elements `xs'
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
  }

  def main(args: Array[String]) {
    val q = Queue[Int]() append 1 append 2
    println(q)
  }
}
