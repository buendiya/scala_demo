package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P19 extends App{
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    else ls.drop(nBounded) ::: ls.take(nBounded)
  }

  println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

}
