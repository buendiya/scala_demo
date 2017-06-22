package src.neophytes_guide.part5


case class User(
                 id: Int,
                 firstName: String,
                 lastName: String,
                 age: Int,
                 gender: Option[String])

object UserRepository {
  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
    2 -> User(2, "Johanna", "Doe", 30, None))
  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}

object Test1 extends App {
  def getFirstName(id: Int) = {
    val user1 = UserRepository.findById(id)
    if (user1.isDefined) user1.get.firstName else "Not specified"
  }

  println(getFirstName(1))
  println(getFirstName(3))

}

object Test2 extends App {
  val user = User(2, "Johanna", "Doe", 30, None)
  println(user.gender.getOrElse("not specified"))

}

object Test3 extends App {
  val user = User(2, "Johanna", "Doe", 30, None)
  val gender = user.gender match {
    case Some(g) => g
    case None => "not specified"
  }

  println(gender)

}

object OptionsCanBeViewedAsCollections extends App {
  def t1 = UserRepository.findById(1).foreach(user => println(user.firstName))

  def mapTest = {
    println(UserRepository.findById(1).map(_.firstName))
    println(UserRepository.findById(3).map(_.firstName))
  }

  def flatMapTest = {
    println(UserRepository.findById(1).map(_.gender))
    println(UserRepository.findById(1).flatMap(_.gender))
    println(UserRepository.findById(3).flatMap(_.gender))

  }

  def filterTest = {
    println(UserRepository.findById(1).filter(_.age > 30))
    println(UserRepository.findById(2).filter(_.age > 30))
    println(UserRepository.findById(3).filter(_.age > 30))

  }

  def forTest = {
    val age = for {
      user <- UserRepository.findById(1)
    } yield user.age

    val gender = for {
      user <- UserRepository.findById(1)
      gender <- user.gender
    } yield gender

    val gender2 = for {
      User(_, _, _, _, Some(gender)) <- UserRepository.findById(1)
    } yield gender

    println(age, gender, gender2)
  }

  def chainOptionsTest = {
    val user1 = UserRepository.findById(1)
    val user3 = UserRepository.findById(3)
    val validUser = user3 orElse user1
    println(validUser)
  }

  chainOptionsTest

}
