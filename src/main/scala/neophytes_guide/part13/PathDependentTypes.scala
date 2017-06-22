package src.neophytes_guide.part13

/**
  * Created by jingsz on 4/19/17.
  */

object Test1 extends App {
  class A {
    class B
    var b: Option[B] = None
  }
  val a1 = new A
  val a2 = new A
  val b1 = new a1.B
  val b2 = new a2.B
  a1.b = Some(b1)
//  a2.b = Some(b1) // does not compile. 因为a1.B 和 a2.B 是不同的类型
}

object Test2 extends App {
  class B
  class A {
    type B2 = B
    var b: Option[B2] = None
  }
  val a1 = new A
  val a2 = new A
  val b1 = new a1.B2
  val b2 = new a2.B2
  a1.b = Some(b1)
  a2.b = Some(b1) // compile succeed. 因为a1.B 和 a2.B 是同一种类型
}


object PathDependentTypes extends App{
  object Franchise {
    case class Character(name: String)
  }
  class Franchise(name: String) {
    import Franchise.Character
    def createFanFiction(lovestruck: Character,
                          objectOfDesire: Character): (Character, Character) =
      (lovestruck, objectOfDesire)
  }

  val starTrek = new Franchise("Star Trek")
  val starWars = new Franchise("Star Wars")

  val quark = Franchise.Character("Quark")
  val jadzia = Franchise.Character("Jadzia Dax")

  val luke = Franchise.Character("Luke Skywalker")
  val yoda = Franchise.Character("Yoda")

  println(starTrek.createFanFiction(lovestruck = jadzia, objectOfDesire = luke))

}

object PathDependentTypes2 extends App{

  class Franchise(name: String) {
    case class Character(name: String)

    def createFanFictionWith(
                              lovestruck: Character,
                              objectOfDesire: Character): (Character, Character) = (lovestruck, objectOfDesire)
  }

  val starTrek = new Franchise("Star Trek")
  val starWars = new Franchise("Star Wars")

  val quark = starTrek.Character("Quark")
  val jadzia = starTrek.Character("Jadzia Dax")

  val luke = starWars.Character("Luke Skywalker")
  val yoda = starWars.Character("Yoda")

//  println(starTrek.createFanFictionWith(lovestruck = jadzia, objectOfDesire = luke))  // compile error
  println(starTrek.createFanFictionWith(lovestruck = jadzia, objectOfDesire = quark))


  def createFanFiction(f: Franchise)(lovestruck: f.Character, objectOfDesire: f.Character) =
    (lovestruck, objectOfDesire)

//  println(createFanFiction(starTrek)(jadzia, luke))   // runtime error. type mismatch
  println(createFanFiction(starTrek)(jadzia, quark))

}
