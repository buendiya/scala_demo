package src.neophytes_guide.part7

import scala.io.Source
import java.net.URL

/**
  * Created by jingsz on 4/10/17.
  */
class TheEitherType {

}

object Test1 extends App {
  def getContent(url: URL): Either[String, Source] = {
    if (url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")
    else
      Right(Source.fromURL(url))
  }

  val content: Either[String, Iterator[String]] =
    getContent(new URL("http://danielwestheide.com")).right.map(_.getLines)
  // content is a Right containing the lines from the Source returned by getContent

  val moreContent: Either[String, Iterator[String]] =
    getContent(new URL("http://google.com")).right.map(_.getLines)
  // moreContent is a Left, as already returned by getContent

  val contentLeft: Either[Iterator[String], Source] =
    getContent(new URL("http://danielwestheide.com")).left.map(Iterator(_))
  // content is the Right containing a Source, as already returned by getContent

  val moreContentLeft: Either[Iterator[String], Source] =
    getContent(new URL("http://google.com")).left.map(Iterator(_))
  // moreContent is a Left containing the msg returned by getContent in an Iterator

  println(content)
  println(moreContent)

  println(contentLeft)
  println(moreContentLeft)

  println(getContent(new URL("http://www.jd.com")))
  println(getContent(new URL("http://www.google.com")))

}
