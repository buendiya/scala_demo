package src.neophytes_guide.part10

case class Email(
                  subject: String,
                  text: String,
                  sender: String,
                  recipient: String)

object Test1 extends App {
  type EmailFilter = Email => Boolean
  def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

  val sentByOneOf: Set[String] => EmailFilter =
    senders => email => senders.contains(email.sender)
  val notSentByAnyOf: Set[String] => EmailFilter =
    senders => (email => !senders.contains(email.sender))
  val minimumSize: Int => EmailFilter = n => email => email.text.size >= n
  val maximumSize: Int => EmailFilter = n => email => email.text.size <= n

  def complement[A](predicate: A => Boolean) = (a: A) => !predicate(a)
  val notSentByAnyOf2 = sentByOneOf andThen(g => complement(g))
  val notSentByAnyOf3 = ((g: Email => Boolean) => complement(g)) compose(sentByOneOf)


  val emailFilter: EmailFilter = notSentByAnyOf3(Set("johndoe@example.com"))
  val mails = Email(
    subject = "It's me again, your stalker friend!",
    text = "Hello my friend! How are you?",
    sender = "johndoe@example.com",
    recipient = "me@example.com") :: Nil


  println(newMailsForUser(mails, emailFilter)) // returns an empty list

}

