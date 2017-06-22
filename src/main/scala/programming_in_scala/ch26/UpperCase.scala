package src.programming_in_scala.ch26

/**
  * Created by jingsz on 4/7/17.
  */
object UpperCase {
  def unapply(s: String): Boolean = if (s.toUpperCase == s) true else false

}
