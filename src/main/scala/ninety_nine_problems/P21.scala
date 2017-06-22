package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P21 extends App{
  def insertAt[A](e: A, n: Int, ls: List[A]): List[A] = ls splitAt(n) match {
    case (pre, post) => pre ::: (e :: post)
  }

  def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = {
    val (pre, post) = ls splitAt(n)
    pre ::: (e :: post)
  }

  println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
  println(insertAt2('new, 1, List('a, 'b, 'c, 'd)))
}
