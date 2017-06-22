package src.snippet.math

/*
http://www.scala-lang.org/api/2.12.0/scala/math/Ordering.html
 */

import scala.util.Sorting

object OrderingDemo extends App{
  val pairs = Array(("a", 5, 2), ("c", 3, 1), ("b", 1, 3))

  // sort by 2nd element
  Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2))
  println(pairs(0))

  // sort by the 3rd element, then 1st
  println(Sorting.quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1))))

}

object OrderingDemo2 extends App{
  import scala.util.Sorting

  case class Person(name:String, age:Int)
  val people = Array(Person("bob", 30), Person("ann", 32), Person("carl", 19))

  // sort by age
  object AgeOrdering extends Ordering[Person] {
    def compare(a:Person, b:Person) = a.age compare b.age
  }

  Sorting.quickSort(people)(AgeOrdering)

}
