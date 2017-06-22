package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P06 extends App{
  def palindromeRecursive[A](ls: List[A]): Boolean = ls == ls.reverse
//  def palindromeRecursive(ls: List[Any]): Boolean = ls == ls.reverse

  val ls1 = List(3, 2, 5, 4)
  val ls2 = List(3, 2, 5, 2, 3)
  println(palindromeRecursive(ls1))
  println(palindromeRecursive(ls2))

}
