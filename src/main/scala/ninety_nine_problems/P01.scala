package src.ninety_nine_problems

object P01 {
  def lastBuiltin[A](ls: List[A]): A = ls.last

  def lastRecursive[A](ls: List[A]): A = {
    ls match {
      case h :: Nil => h
      case _ :: tail => lastRecursive(tail)
      case _ => throw new NoSuchElementException
    }
  }

  def main(args: Array[String]): Unit = {
    val ls = List(3, 2, 5)
    println(lastBuiltin(ls))
    println(lastRecursive(ls))

  }

}
