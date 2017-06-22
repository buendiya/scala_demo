package src.snippet

/**
  * Created by jingsz on 4/9/17.
  */
class CaseSequencesAsPartialFunctions {

}


object Test1 extends App {
  def withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }
  println(withDefault(Some(10)), withDefault(None))

}

object Test2 extends App {
//  def second: List[Int] => Int = {
//    case _ :: s :: _ => s
//  }

  def second2: PartialFunction[List[Int], Int] = {
    case _ :: s :: _ => s
  }

  val l = List(1,2,3)
//  println(second(l))

  println(second2(l))
  println(second2.isDefinedAt(l))
  println(second2.isDefinedAt(List()))

}
