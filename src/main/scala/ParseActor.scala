import akka.actor.{Actor, _}
import org.jsoup.Jsoup

import scala.collection.JavaConversions._

class ParseActor extends Actor {

  def receive = {
    case DoParse(url) =>
      println(s"scraping $url")
      val result = parse(url)
      sender ! ParseFinished(result)
  }

  def parse(url: String): Map[String, (String, String)] = {

    val page = Jsoup.connect(url).ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1").get()

    val productLists = page.body().getElementById("productLists").getElementsByAttributeValue("class", "productDetails")
    val f = for (x <- productLists) yield (x.select("a").first().attr("href"), x.text())
    val x = f.map {
      case (link, description) =>
        (link.split("/").last, (description.split(" ")(0), description.split("€")(1).split(" ")(0).tail))
    }.toMap
    x
  }

}