package src.programming_in_scala.ch20.p6

/**
  * Created by jingsz on 4/19/17.
  */
object BuggyAnimals extends App{
  class Food
  abstract class Animal {
    def eat(food: Food)
  }

  class Grass extends Food
//  class Cow extends Animal {
//    override def eat(food: Grass) = {} // This won't compile
//  }

}
