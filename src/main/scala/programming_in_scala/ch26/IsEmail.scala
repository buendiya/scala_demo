package src.programming_in_scala.ch26


object IsEmail {
  def isEmail(s: String) =
    s match {
      case EMail(user, domain) => println(user + " AT " + domain)
      case _ => println("not an email address")
    }
}
