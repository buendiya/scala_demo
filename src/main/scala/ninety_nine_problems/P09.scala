package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P09 extends App{
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span {_ == ls.head}
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
}
