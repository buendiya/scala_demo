package src.snippet

/**
  * Created by jingsz on 4/6/17.
  */
object ImplicitParameterTest extends App{
  val value = 3
  val monday = true


  // both of the bellowing define a implicit value, but there can exist one at the same time
  implicit val m = 2
//  implicit def f: Int = if (monday) 4 else 2

  implicit val ms = "s"


  def multiply(implicit by: Int) = value * by

  println(multiply)


}
