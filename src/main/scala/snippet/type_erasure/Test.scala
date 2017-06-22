package src.snippet.type_erasure

// https://medium.com/byte-code/overcoming-type-erasure-in-scala-8f2422070d20

import scala.reflect.ClassTag

/*
our desire is to have a method that takes a list of mixed objects and
extracts only objects of certain type
 */

/*
compile the Extractor will get the following warning
Warning: abstract type pattern T is unchecked since it is eliminated by erasure
    case element: T => Some(element)
*/

//object Extractor {
//  def extract[T](list: List[Any]) = list.flatMap {
//    case element: T => Some(element)
//    case _ => None
//  }
//}


object Extractor2 {
  def extract[T](list: List[Any])(implicit tag: ClassTag[T]) =
    list.flatMap {
      case element: T => Some(element)
      case _ => None
    }
}


object Test extends App {
  val list = List(1, "string1", List(), "string2")
//  println(Extractor.extract[String](list)) // List(1, string1, List(), string2)
  println(Extractor2.extract[String](list))
}
