package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P10 extends App{
  import P09.pack
  def encode[A](ls: List[A]): List[(Int, A)] = {
    pack(ls) map {e => (e.length, e.head)}
  }

  def encode2[A](ls: List[A]): List[(Int, A)] = {
    val packedLs = P09.pack(ls)
    packedLs.foldLeft(List[(Int, A)]()) {
      (r, h) => r ::: List((h.length, h.head))
    }
  }

  println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
}
