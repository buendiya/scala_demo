package src.neophytes_guide.part3

/**
  * Created by jingsz on 4/8/17.
  */
object Test1 extends App{
  def gameResults(): Seq[(String, Int)] =
    ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil


  def hallOfFame = for {
    result <- gameResults
    (name, score) = result
    if (score > 5000)
  } yield name

  def hallOfFame2 = for {
    (name, score) <- gameResults
    if (score > 5000)
  } yield name

  println(hallOfFame)
  println(hallOfFame2)

}



//The pattern on the left side of the generator does not match for empty lists.
//This will not throw a MatchError,
//but result in any empty list being removed. Hence, we get back List(3, 2).
object Test2 extends App {
  val lists = List(1, 2, 3) :: List.empty :: List(5, 3) :: Nil

  val listSize = for {
    list @ head :: _ <- lists
  } yield(list, list.size)

  println(listSize)
}

