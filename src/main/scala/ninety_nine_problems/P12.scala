package src.ninety_nine_problems

/**
  * Created by jingsz on 4/6/17.
  */
object P12 extends App{
    def decode[A](ls: List[(Int, A)]): List[A] =
      ls flatMap { e => List.fill(e._1)(e._2) }

  println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))

}
