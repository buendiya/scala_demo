package src.programming_in_scala.ch26

/**
  * Created by jingsz on 4/7/17.
  */
class EMail {

}

object EMail {

  // The injection method (optional)
  def apply(user: String, domain: String) = user + "@" + domain

  // The extraction method (mandatory)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1))
//    if (parts.length == 2) Some((parts(0), parts(1)))
    else None
  }
}
