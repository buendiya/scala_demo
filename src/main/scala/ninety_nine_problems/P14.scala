package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P14 extends App{
  def duplicate[A](ls: List[A]): List[A] = {
    ls flatMap (e => List(e, e))
  }

  println(duplicate(List('a, 'b, 'c, 'c, 'd)))

}
