package src.programming_in_scala.ch25

/**
  * Created by jingsz on 4/18/17.
  */
object ContextBounds {
  object Test2 {
    def maxList[T](elements: List[T])
                  (implicit ordering: Ordering[T]): T =
      elements match {
        case List() =>
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)     // (ordering) is implicit
          if (ordering.gt(x, maxRest)) x  // this ordering is
          else maxRest                    // still explicit
      }
  }

  /*
  There is not a single mention of the ordering parameter in the text of the method.
   */
  object Test3 {
    def maxList[T](elements: List[T])
                  (implicit ordering: Ordering[T]): T =
      elements match {
        case List() =>
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)
          if (implicitly[Ordering[T]].gt(x, maxRest)) x   //
          else maxRest
      }
  }

  /*
  context bound
   */
  object Test4 {
    def maxList[T : Ordering](elements: List[T]): T =   //
      elements match {
        case List() =>
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxList(rest)
          if (implicitly[Ordering[T]].gt(x, maxRest)) x
          else maxRest
      }
  }

  def main(args: Array[String]): Unit = {
    println(Test2.maxList(List(1, 2, 3)))
    println(Test3.maxList(List(1, 2, 3)))
    println(implicitly[Ordering[Int]])
    println(Test4.maxList(List(1, 2, 3)))
  }

}

