package src.tutorial

/**
  * Created by jingsz on 4/6/17.
  */

object CurryTest extends App {
  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p)

  def filter2(xs: List[Int], p: Int => Boolean): List[Int] = xs match {
    case Nil => Nil
    case h :: tail => {
      if (p(h)) h :: filter2(tail, p)
      else filter2(tail, p)
    }
  }

  // currying function
  def modN(n: Int)(x: Int) = ((x % n) == 0)

  // partially applied function
  def modN2(n: Int, x: Int) = ((x % n) == 0)

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
  println(filter(nums, modN(2)))
  println(filter(nums, modN(3)))

  println(filter2(nums, modN(2)))
  println(filter2(nums, modN(3)))

  println(filter(nums, modN2(2, _)))
  println(filter(nums, modN2(3, _)))
}
