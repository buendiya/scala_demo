package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P03 extends App{
  def nthBuiltin[A](n: Int, ls: List[A]): A = {
    if (n >= 0) ls(n)
    else throw new NoSuchElementException
  }

  def nthRecursive[A](n: Int, ls: List[A]): A = {
    (n, ls) match {
      case (0, h :: _) => h
      case (n, _ :: tail) => nthRecursive(n - 1, tail)
      case (n, Nil) => throw new NoSuchElementException
    }
  }

  val ls = List(3, 2, 5)
  println(nthBuiltin(2, ls))
  println(nthRecursive(2, ls))

}
