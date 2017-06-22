package src.neophytes_guide.part11

case class Email(
                  subject: String,
                  text: String,
                  sender: String,
                  recipient: String)


object Test1 extends App {
  type IntPairPred = (Int, Int) => Boolean
  val gt: IntPairPred = _ > _
  val ge: IntPairPred = _ >= _
  val lt: IntPairPred = _ < _
  val le: IntPairPred = _ <= _
  val eq: IntPairPred = _ == _

  type EmailFilter = Email => Boolean
  def sizeConstraint(pred: IntPairPred, n: Int, email: Email) = pred(email.text.size, n)

  val minimumSize: (Int, Email) => Boolean = sizeConstraint(gt, _: Int, _: Email)
  val maximumSize: (Int, Email) => Boolean = sizeConstraint(lt, _: Int, _: Email)

  val constr20: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred, 20, _: Email)
  val constr30: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred, 30, _: Email)

  val min20: EmailFilter = minimumSize(20, _: Email)
  val min20_2: EmailFilter = constr20(gt, _: Email)

  // currying
  def sizeConstraint_2(pred: IntPairPred)(n: Int)(email: Email): Boolean = pred(email.text.size, n)
  def minSize: Int => Email => Boolean = sizeConstraint_2(gt)
  def min20_3: Email => Boolean = minSize(20)
  def min20_4: Email => Boolean = sizeConstraint_2(gt)(20)


  val mails = Email(
    subject = "It's me again, your stalker friend!",
    text = "Hello my friend! How are you? Hello my friend! How are you?",
    sender = "johndoe@example.com",
    recipient = "me@example.com") :: Nil

  println(mails.filter(min20)) // returns an empty list
}