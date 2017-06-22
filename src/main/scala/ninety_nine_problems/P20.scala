package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P20 extends App{
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, h :: post) => (pre ::: post, h)
    case (_, Nil) =>  throw new NoSuchElementException
  }

  println(removeAt(1, List('a, 'b, 'c, 'd)))
  println(removeAt(0, List('a, 'b, 'c, 'd)))

}
