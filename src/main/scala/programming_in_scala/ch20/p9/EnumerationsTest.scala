package src.programming_in_scala.ch20.p9

/**
  * Created by jingsz on 4/19/17.
  */
class EnumerationsTest {
  object Color extends Enumeration {
    val Red, Green, Blue = Value("")
  }

  object Color2 extends Enumeration {
    val Red, Green, Blue = Value("")
  }

  var o: Color.Value = Color.Red
  var o2 = Color2.Red

//  o2 = o    // type mismatch


}
