package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P05 extends App{

  def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse

  def reverseRecursive[A](ls: List[A]): List[A] = {
    ls match {
      case Nil => Nil
      case h :: tail => reverseRecursive(tail) ::: List(h)
    }
  }

  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def inner[A](init: List[A], ls: List[A]): List[A] = {
      ls match {
        case Nil => init
        case h :: tail => inner(h :: init, tail)
      }
    }
    inner(Nil, ls)
  }

  def reverseFunctional[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) { (r, h) => h :: r}

  val ls = List(3, 2, 5)
  println(reverseBuiltin(ls))
  println(reverseRecursive(ls))
  println(reverseTailRecursive(ls))
  println(reverseFunctional(ls))
}
