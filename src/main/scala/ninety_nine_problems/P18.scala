package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P18 extends App{
  def sliceBuiltin[A](start: Int, end: Int, ls: List[A]): List[A] =
    ls slice(start, end)

  def sliceFunctional[A](start: Int, end: Int, ls: List[A]): List[A] =
    ls drop start take (end - start)

  def sliceFunctional2[A](start: Int, end: Int, ls: List[A]): List[A] =
    ls.drop(start).take(end - start)

  println(sliceBuiltin(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(sliceFunctional(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(sliceFunctional2(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

}
