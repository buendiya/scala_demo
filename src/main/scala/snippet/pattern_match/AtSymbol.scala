package src.snippet.pattern_match


// http://stackoverflow.com/questions/2359014/scala-operator

case class Box(i: Int, j: Int)

object AtSymbol extends App {
  val o = Some(2)
  o match {
    case o @ Some(2) => println(o)
    case none => println("nothing", none)
  }

  // match object
  val b = Box(1, 2)
  b match {
    case bSelf @ Box(x, y) => println(bSelf, x, y)
  }

  // match type
  b match {
    case bSelf: Box => println(bSelf)
  }
}
