package src.programming_in_scala

/**
  * Created by jingsz on 3/27/17.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)
  val numer: Int = n
  val denom: Int = d

  def this(n: Int) = this(n, 1)
  override def toString: String = "Rational: " + n + "/" + d

  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) =
    if (this.lessThan(that)) that else this

  def add(that: Rational): Rational = new Rational(n + that.numer, d + that.denom)
  def +(that: Rational): Rational = new Rational(n + that.numer, d + that.denom)
}

object Main {
  def main(args: Array[String]) {
    val r = new Rational(1, 2)
    val r2 = new Rational(1)
    println(r.add(r2))
    println(r add r2)
    println(r + r2)
  }
}
