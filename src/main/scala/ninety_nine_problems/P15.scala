package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P15 extends App{
  def duplicate[A](n: Int, ls: List[A]): List[A] = {
    ls flatMap (e => List.fill(n)(e))
  }

  def duplicate2[A](n: Int, ls: List[A]): List[A] = {
    ls flatMap (List.fill(n)(_))
  }

  println(duplicate(3, List('a, 'b, 'c, 'c, 'd)))
  println(duplicate2(3, List('a, 'b, 'c, 'c, 'd)))

}
