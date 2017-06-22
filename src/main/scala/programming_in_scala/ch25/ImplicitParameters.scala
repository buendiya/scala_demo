package src.programming_in_scala.ch25

object ImplicitParameters {
  class PreferredPrompt(val preference: String)

  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt) = {
      println("Welcome, " + name + ". The system is ready.")
      println(prompt.preference)
    }
  }

  object JoesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master> ")
  }

  def main(args: Array[String]) {
    val bobsPrompt = new PreferredPrompt("relax> ")
    Greeter.greet("Bob")(bobsPrompt)

    import JoesPrefs._
    Greeter.greet("Joe")
  }

}


object Test2 extends App {
  class PreferredPrompt(val preference: String)
  class PreferredDrink(val preference: String)
  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt,
                            drink: PreferredDrink) = {
      println("Welcome, " + name + ". The system is ready.")
      print("But while you work, ")
      println("why not enjoy a cup of " + drink.preference + "?")
      println(prompt.preference)
    }
  }

  object JoesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master> ")
    implicit val drink = new PreferredDrink("tea")
  }

  import JoesPrefs._
  Greeter.greet("Joe")

}

object Test3 extends App {
  def maxListOrdering[T](elements: List[T])
                        (ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering(rest)(ordering)
        if (ordering.gt(x, maxRest)) x
        else maxRest
    }

}

object MaxListImpParm {
  def maxListImpParm[T](elements: List[T])
                       (implicit ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(ordering)
        if (ordering.gt(x, maxRest)) x
        else maxRest
    }
}

object Test4 extends App {
  val l = List(1,5,10,3)
  println(MaxListImpParm.maxListImpParm(l))
}



// Test5 和 Test6都定义了Person的implicit Ordering；
// Test5 的方法参照scala.math.Ordering里Int, String等的实现方法
// Test7是通常做法
object Test5 extends App {

  case class Person(name:String, age:Int)
  val people = List(Person("bob", 30), Person("ann", 32), Person("carl", 19))

  trait AgeOrdering extends Ordering[Person] {
    def compare(a:Person, b:Person) = a.age compare b.age
  }
  implicit object Person extends AgeOrdering

  println(MaxListImpParm.maxListImpParm(people))
}


object Test6 extends App {

  case class Person(name:String, age:Int)
  val people = List(Person("bob", 30), Person("ann", 32), Person("carl", 19))

  implicit object AgeOrdering extends Ordering[Person] {
    def compare(a:Person, b:Person) = a.age compare b.age
  }

  println(MaxListImpParm.maxListImpParm(people))
}

object Test7 extends App {

  case class Person(name:String, age:Int)
  val people = List(Person("bob", 30), Person("ann", 32), Person("carl", 19))

  class AgeOrdering extends Ordering[Person] {
    def compare(a:Person, b:Person) = a.age compare b.age
  }

  println(MaxListImpParm.maxListImpParm(people)(new AgeOrdering()))
}
