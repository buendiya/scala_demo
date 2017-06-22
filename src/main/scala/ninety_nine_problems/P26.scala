package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */

object P26  extends App{
  // flatMapSublists is like list.flatMap, but instead of passing each element
  // to the function, it passes successive sublists of L.
  def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
  ls match {
    case Nil => Nil
    case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
  }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map {sl.head :: _}
    }

  println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))
}
