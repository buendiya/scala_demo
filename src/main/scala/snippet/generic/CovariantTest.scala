package snippet.generic


class C1[A]
class C2[+A]

object CovariantTest {
  // below is not working
//  val c1: C1[AnyVal] = new C1[Int]

  val c2: C2[AnyVal] = new C2[Int]

}
