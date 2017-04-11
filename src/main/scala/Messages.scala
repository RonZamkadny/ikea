import scala.collection.mutable

case class Start(url: String)
case class DoParse(url: String)
case class DoIndex(buffer: Map[String, (String, String)])
case class ParseFinished(buffer: Map[String, (String, String)])
case class IndexFinished(url: String)