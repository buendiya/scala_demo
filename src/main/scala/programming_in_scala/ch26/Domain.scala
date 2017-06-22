package src.programming_in_scala.ch26

/**
  * Created by jingsz on 4/7/17.
  */

object Domain {

  // The injection method (optional)
  def apply(parts: String*): String =
    parts.reverse.mkString(".")

//  def unapply(whole: String): Option[String] =
//    Some(whole.reverse)

  // The extraction method (mandatory)
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

