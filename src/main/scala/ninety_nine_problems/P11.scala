package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P11 extends App{
  import P10.encode
  def encodeModified[A](ls: List[A]): List[Any] = {
    encode(ls) map {e =>
      if (e._1 == 1) e._2
      else e}
  }

  // Just for fun, here's a more typesafe version.
  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
    encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }


  println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  println(encodeModified2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
}
