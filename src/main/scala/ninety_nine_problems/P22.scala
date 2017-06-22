package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P22 extends App{
  def rangeBuiltin(start: Int, end: Int): List[Int] = List.range(start, end+1)
  def rangeBuiltin2(start: Int, end: Int): List[Int] = (start to end).toList
  def rangeBuiltin3(start: Int, end: Int): List[Int] = (start until end).toList

  println(rangeBuiltin(4, 9))
  println(rangeBuiltin2(4, 9))
  println(rangeBuiltin3(4, 9))

}
