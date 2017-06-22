package src.neophytes_guide.part13

object AbstractTypeMembers extends App{
  object AwesomeDB {
    abstract class Key(name: String) {
      type Value
    }
  }

  import AwesomeDB.Key
  class AwesomeDB {
    import collection.mutable.Map
    val data = Map.empty[Key, Any]
    def get(key: Key): Option[key.Value] = data.get(key).asInstanceOf[Option[key.Value]]
    def set(key: Key)(value: key.Value): Unit = data.update(key, value)
  }

  trait IntValued extends Key {
    type Value = Int
  }
  trait StringValued extends Key {
    type Value = String
  }
  object Keys {
    val foo = new Key("foo") with IntValued
    val bar = new Key("bar") with StringValued
  }

  val dataStore = new AwesomeDB
  dataStore.set(Keys.foo)(23)
  val i: Option[Int] = dataStore.get(Keys.foo)
//  dataStore.set(Keys.foo)("23") // does not compile

}
