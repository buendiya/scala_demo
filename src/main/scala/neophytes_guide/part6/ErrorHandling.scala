package src.neophytes_guide.part6

/**
  * Created by jingsz on 4/10/17.
  */

case class Customer(age: Int)
class Cigarettes
case class UnderAgeException(message: String) extends Exception(message)

object Test1 extends App {
  def buyCigarettes(customer: Customer): Cigarettes =
    if (customer.age < 16)
      throw new  UnderAgeException(s"Customer must be older than 16 but was ${customer.age}")
    else new Cigarettes

  val youngCustomer = new Customer(15)
  try {
    buyCigarettes(youngCustomer)
  } catch {
    case UnderAgeException(msg) => println(msg)
  }
}