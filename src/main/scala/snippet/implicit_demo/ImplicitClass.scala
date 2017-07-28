package snippet.implicit_demo

//http://alvinalexander.com/scala/scala-2.10-implicit-class-example

object StringUtils {
  implicit class StringImprovements(val s: String) {
    def increment = s.map(c => (c + 1).toChar)
  }
}

object ImplicitClass extends App {
  import StringUtils._

  println("HAL".increment)
}

