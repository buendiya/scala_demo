package src.neophytes_guide.part4

/**
  * Created by jingsz on 4/8/17.
  */
class PatternMatchingAnonymousFunctions {

}

object Test1 extends App{
  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
    ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

  def wordWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] = {
    wordFrequencies.filter(wf => wf._2 > 3 && wf._2 < 25).map(_._1)
  }

  def wordWithoutOutliers2(wordFrequencies: Seq[(String, Int)]): Seq[String] = {
    wordFrequencies.filter {case (_, f) => f > 3 && f < 25} map {case(w, _) => w}
  }

  def wordWithoutOutliers3(wordFrequencies: Seq[(String, Int)]): Seq[String] = {
    wordFrequencies.map {case(w, f) if f > 3 && f < 25 => w}
  }

  val pf: PartialFunction[(String, Int), String] = {
    case (word, frequency) if frequency > 3 && frequency < 25 => word
  }

  val pf2 = new PartialFunction[(String, Int), String] {
    def apply(wordFrequency: (String, Int)) = wordFrequency match {
      case (word, freq) if freq > 3 && freq < 25 => word
    }
    def isDefinedAt(wordFrequency: (String, Int)) = wordFrequency match {
      case (word, freq) if freq > 3 && freq < 25 => true
      case _ => false
    }
  }

  val predicate: ((String, Int)) => Boolean = {case (_, f) => f > 3 && f < 25}

  println(wordWithoutOutliers(wordFrequencies))
  println(wordWithoutOutliers2(wordFrequencies))
  // below will have MatchError when running
//  println(wordWithoutOutliers3(wordFrequencies))

  println(wordFrequencies.collect(pf))
  // below will have MatchError when running
//  println(wordFrequencies.map(pf))


}
