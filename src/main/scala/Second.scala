
import scala.io.Source


object PrintFile {
  val s = 'printFile
  def widthOfLength(s: String) = s.length.toString.length

  def printFile(args: Array[String]) = {
    if (args.length > 0) {
      val lines:List[String] = Source.fromFile(args(0)).getLines().toList
      val maxLengthLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b
      )
      val maxWidth = widthOfLength(maxLengthLine)
      lines.foreach(line => {
        val numSpaces = maxWidth - widthOfLength(line)
        val padding = " " * numSpaces
        println(padding + line.length + "|" + line)
      })
    }
    else
      Console.err.print("Please enter filename")
  }
}


object Second {
  def main(args: Array[String]): Unit = {
    PrintFile.printFile(Array("/Users/jingsz/migrate_hadoop.txt"))
  }
}
