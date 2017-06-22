package src.programming_in_scala.ch15


object CaseSequencesAsPartialFunctions extends App{
//  val second: List[Int] => Int = {
//    case x :: y :: _ => y
//  }
//
//  println(second(List(1, 2, 3)))
//  println(second(List()))

}


object CaseSequencesAsPartialFunctions2 extends App{
  val second: PartialFunction[List[Int],Int] = {
    case x :: y :: _ => y
  }

  println(second(List(1, 2, 3)))
  if (second.isDefinedAt(List()))
    println(second(List()))

}
