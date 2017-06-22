package src.ninety_nine_problems

/**
  * Created by jingsz on 4/5/17.
  */
object P02 extends App{
  def penultimateBuilt[A](ls: List[A]): A = {
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last
  }

  def penultimateRecursive[A](ls: List[A]): A = {
    ls match {
      case h :: _ :: Nil => h
      case _ :: tail => penultimateRecursive(tail)
      case _  => throw new NoSuchElementException
    }
  }

  val ls = List(3, 2, 5)
  println(penultimateRecursive(ls))
  println(penultimateBuilt(ls))

}
