package src.programming_in_scala.ch26

/**
  * Created by jingsz on 4/7/17.
  */

object Test2 {
  def userTwiceUpper(s: String) = s match {
    case EMail(Twice(x @ UpperCase()), domain) =>
      "match: " + x + " in domain " + domain
    case _ =>
      "no match"
  }
}

object Main extends App {
  println(Test2.userTwiceUpper("DIDI@hotmail.com"))
  println(Test2.userTwiceUpper("DIDO@hotmail.com"))
  println(Test2.userTwiceUpper("didi@hotmail.com"))
}
