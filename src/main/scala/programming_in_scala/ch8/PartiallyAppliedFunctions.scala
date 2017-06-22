package src.programming_in_scala.ch8


/*
Although you can't assign a method or nested function to a variable
you can do these things if you wrap the method or nested function in a function value
by placing an underscore after its name.
 */
object Test1 extends App {
  def f1(x: Int) = x + 1
  def f2(f: Int => Int) = f(1) + 1

  // below not working.
  //  val f3 = f1
  val f3 = f1 _
  println(f2(f3))
}


object Test2 extends App {
  def sum(x: Int, y: Int, z: Int) = x + y + z
  def partiallySum = sum(1, _: Int, 3)

  println(partiallySum(2))

}


class PartiallyAppliedFunctions {

}
