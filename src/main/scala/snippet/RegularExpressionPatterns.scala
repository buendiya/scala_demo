package src.snippet

/**
  * Created by jingsz on 4/6/17.
  */
class RegularExpressionPatterns {

}

object RegExpTest1 extends App {
  def containsScala(x: String): Boolean = {
    val z: Seq[Char] = x
    z match {
      // The @ is a special Scala notation, means that on the left is an alias to the pattern on the right
      case Seq('s','c','a','l','a', rest @ _*) =>
        println("rest is "+rest)
        true
      case Seq(_*) =>
        false
    }
  }

  containsScala("hello")
  containsScala("scala, hello")
}
