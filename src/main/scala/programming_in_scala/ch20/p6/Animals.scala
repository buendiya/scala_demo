package src.programming_in_scala.ch20.p6


object Animals extends App{
  class Food
  abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood)
  }

  class Grass extends Food
  class Cow extends Animal {
    type SuitableFood = Grass
    override def eat(food: Grass) = {println("I am eating grass")}
  }

  class Fish extends Food
  val bessy = new Cow
  bessy.eat(new Grass)
  //  bessy.eat(new Fish)

  val bessy2: Animal = new Cow
//  bessy2.eat(new Grass)
}
