package src.neophytes_guide.part1

/**
  * Created by jingsz on 4/7/17.
  */

trait User {
  def name: String
  def score: Int
}

class FreeUser(val name: String, val score: Int, val upgradeProbability: Double)
  extends User

class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] =
    Some((user.name, user.score, user.upgradeProbability))
}

object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}

object premiumCandidate {
  def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}

object Test extends App {

  def getGreetingWords(user: User) = {
    user match {
      case FreeUser(name, _, p) =>
        if (p > 0.75) name + ", what can we do for you today?" else "Hello " + name
      case PremiumUser(name, _) => "Welcome back, dear " + name
        // the below also working
//      case name PremiumUser _ => "Welcome back, dear " + name
    }
  }

  def test1 = {
    val user: User = new FreeUser("Daniel", 3000, 0.7d)
    val user2: User = new PremiumUser("Daniel", 3000)
    println(getGreetingWords(user))
    println(getGreetingWords(user2))
  }

  def test2 = {
    val user: User = new FreeUser("Daniel", 2500, 0.8d)
    user match {
      case freeUser @ premiumCandidate() => println("initiateSpamProgram(freeUser)")
      case _ => println("sendRegularNewsletter(user)")
    }
  }

  test1
}