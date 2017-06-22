package src.programming_in_scala.ch7

/**
  * Created by jingsz on 3/28/17.
  */
object MultiTable2 extends App{

  def makeRowSeq(row: Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }

  // Returns a row as a string
  def makeRow(row: Int) = makeRowSeq(row).mkString

  // Returns table as a string with one row per line
  def multiTable() = {

    val tableSeq = // a sequence of row strings
      for (row <- 1 to 10)
        yield makeRow(row)

    tableSeq.mkString("\n")
  }

  println("multiTable [" + multiTable + "]")

}
