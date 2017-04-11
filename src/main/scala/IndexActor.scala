import akka.actor.{Actor, ActorSystem}
import org.jsoup.Jsoup
import akka.actor._

class IndexActor(system: ActorSystem) extends Actor {

  def receive = {
    case DoIndex(url) =>
      println(s"scraping $url")
      val content = parse("")
      sender ! IndexFinished("")
  }

  def parse(url: String): Unit = {
    val link: String = url.toString
    val response = Jsoup.connect(link)
      .ignoreContentType(true).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1").execute()

    val contentType: String = response.contentType

  }
}