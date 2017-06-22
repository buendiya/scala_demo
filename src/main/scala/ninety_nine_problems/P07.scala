package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P07 extends App{
//  def flatten(ls: List[List[Any]]): List[Any] = ls.foldLeft(List[Any]()) {(h, r) => h ::: r}

  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

  val ls = List(List(1, 1), 2, List(3, List(5, 8)))
  println(flatten(ls))

}
