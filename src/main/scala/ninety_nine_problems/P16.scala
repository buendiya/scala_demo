package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P16 extends App{
  def dropFunctional[A](n: Int, ls: List[A]): List[A] = {
    ls.zipWithIndex filter {
      v => (v._2 + 1) % n != 0
    } map { _._1}
  }

  println(dropFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

}
