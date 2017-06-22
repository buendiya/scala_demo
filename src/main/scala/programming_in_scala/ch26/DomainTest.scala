package src.programming_in_scala.ch26

/**
  * Created by jingsz on 4/7/17.
  */

object DomainTest {
  def test(dom: String) =
    dom match {
      case Domain("org", "acm") => println("acm.org")
      case Domain("com", "sun", "java") => println("java.sun.com")
      case Domain("net", _*) => println("a .net domain")
    }

  def isTomInDotCom(s: String): Boolean = s match {
    case EMail("tom", Domain("com", _*)) => true
    case _ => false
  }
}

object Test extends App {
  println(DomainTest.isTomInDotCom("tom@sun.com"))

  println(DomainTest.isTomInDotCom("peter@sun.com"))

  println(DomainTest.isTomInDotCom("tom@acm.org"))
}
