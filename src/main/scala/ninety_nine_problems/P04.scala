package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P04 extends App{
  def lengthBuiltin[A](ls: List[A]): Int = ls.length

  def lengthRecursive[A](ls: List[A]): Int = {
    ls match {
      case Nil => 0
      case _ :: tail => 1 + lengthRecursive(tail)
    }
  }

  def lengthTailRecursive[A](ls: List[A]): Int = {
    def inner[A](init: Int, ls: List[A]): Int = {
      ls match {
        case Nil => init
        case _ :: tail => inner(init + 1, tail)
      }
    }
    inner(0, ls)
  }

  def lengthFunctional[A](ls: List[A]): Int = ls.foldLeft(0) { (c, _) => c + 1}
  def lengthFunctional2[A](ls: List[A]): Int = ls.foldLeft(0) ( (c, _) => c + 1)

  val ls = List(3, 2, 5)
  println(lengthBuiltin(ls))
  println(lengthRecursive(ls))
  println(lengthTailRecursive(ls))
  println(lengthFunctional(ls))
  println(lengthFunctional2(ls))

}
