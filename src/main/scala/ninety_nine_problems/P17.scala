package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P17 extends App{
  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) =
    (n, ls) match {
      case (_, Nil) => (Nil, Nil)
      case (0, list) => (Nil, list)
      case (n, h :: tail) => {
        val (pre, post) = splitFunctional(n - 1, tail)
        (h :: pre, post)
      }
    }

  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
    (ls.take(n), ls.drop(n))

  println(splitFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(splitRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
}
