package src.tutorial

/**
  * Created by jingsz on 4/6/17.
  */
class IntPair(val x: Int, val y: Int)

object IntPair {
  import math.Ordering

  implicit def ipord: Ordering[IntPair] =
    Ordering.by(ip => (ip.x, ip.y))
}

class SingletonTest {
  val ip1 = new IntPair(1, 2)
  val ip2 = new IntPair(1, 3)

}
