package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P23 extends App{
  import P20.removeAt

  def randomSelect[A](n: Int, ls: List[A]): List[A] =
    if (n <= 0) Nil
    else {
      val randomValue = (new util.Random).nextInt(ls.length)
      val (rest, e) = removeAt(randomValue, ls)
      e :: randomSelect(n - 1, rest)
    }

  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

}
