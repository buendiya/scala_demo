package src.programming_in_scala.ch19


object Queues extends App{
  class Queue[T] (
                  private val leading: List[T],
                  private val trailing: List[T]
                ) {
    private def mirror =
      if (leading.isEmpty)
        new Queue(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head

    def tail = {
      val q = mirror
      new Queue(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new Queue(leading, x :: trailing)

    override def toString =
      leading ::: trailing.reverse mkString ("Queue(", ", ", ")")
  }

  object Queue {
    // constructs a queue with initial elements `xs'
    def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
  }

  val q = Queue[Int]() enqueue 1 enqueue 2 enqueue 3
  println(q.tail)

  val q2 = new Queue[Int](List(1, 2), List(3, 4))
  println(q2)
}