package src.programming_in_scala.ch26

/**
  * Created by jingsz on 4/7/17.
  */
object Misc {
  def test2: Unit = {
    val email = EMail("hello", "163.com")
    val EMail(user, domain) = email;
    println(user, domain)
  }

  def main(args: Array[String]) {
    IsEmail.isEmail("foo@bar.com")

    val user = "foo"
    val domain = "bar.com"
    val result1 =
      EMail.unapply(EMail.apply(user, domain))
    println("result1 [" + result1 + "]")

    test2

  }
}
