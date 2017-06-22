package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P08 extends App{
  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  // Tail recursive.
  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil => result.reverse
    }
    compressR(Nil, ls)
  }

  def compress[A](ls: List[A]): List[A] = ls.foldLeft(List[A]()) {
    (r, h) =>
      if (r.isEmpty || h != r.last) r ::: List(h)
      else r
  }

  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  println(compress(ls))
  println(compressRecursive(ls))
  println(compressTailRecursive(ls))

}
