package neophytes_guide.part14

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.{ActorRef, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.Future


sealed trait CoffeeRequest
case object CappuccinoRequest extends CoffeeRequest
case object EspressoRequest extends CoffeeRequest


class Barista extends Actor {
  def receive = {
    case CappuccinoRequest => println("I have to prepare a cappuccino!")
    case EspressoRequest => println("Let's prepare an espresso.")
  }
}


object BaristaTest extends App {
  val system = ActorSystem("Barista")
  val barista: ActorRef = system.actorOf(Props[Barista], "Barista")
  barista ! CappuccinoRequest
  barista ! EspressoRequest
  println("I ordered a cappuccino and an espresso")
  Thread.sleep(1000)
}


case class Bill(cents: Int)
case object ClosingTime

class Barista2 extends Actor {
  def receive = {
    case CappuccinoRequest =>
      sender ! Bill(250)
      println("I have to prepare a cappuccino!")
    case EspressoRequest =>
      sender ! Bill(200)
      println("Let's prepare an espresso.")
    case ClosingTime => context.system.terminate()
  }
}

case object CaffeineWithdrawalWarning
class Customer(caffeineSource: ActorRef) extends Actor {
  def receive = {
    case CaffeineWithdrawalWarning => caffeineSource ! EspressoRequest
    case Bill(cents) => println(s"I have to pay $cents cents, or else!")
  }
}


object BaristaTest2 extends App {
  val system = ActorSystem("Barista")
  val barista = system.actorOf(Props[Barista2], "Barista")
  val customer = system.actorOf(Props(classOf[Customer], barista), "Customer")
  customer ! CaffeineWithdrawalWarning
  barista ! ClosingTime

  Thread.sleep(1000)
}


object BaristaTest3 extends App {
  implicit val timeout = Timeout(2.second)
  val system = ActorSystem("Barista")
  implicit val ec = system.dispatcher
  val barista2 = system.actorOf(Props[Barista2], "Barista")
  val f: Future[Any] = barista2 ? CappuccinoRequest
  f.onSuccess {
    case Bill(cents) => println(s"Will pay $cents cents for a cappuccino")
  }
  barista2 ! ClosingTime

  Thread.sleep(1000)
}
