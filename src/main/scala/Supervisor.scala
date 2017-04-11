import akka.actor.{Actor, ActorSystem, _}

class Supervisor(system: ActorSystem) extends Actor {

  lazy val parseActor = system.actorOf(Props(new ParseActor()), name = "parseActor")
  lazy val indexActor = system.actorOf(Props(new IndexActor(system)), name = "indexActor")
  var accumulator = Map[String, (String, String)]()

  override def receive = {
    case Start(url) =>
      parseActor ! DoParse(url)
    case ParseFinished(buffer) =>

      accumulator = accumulator ++ buffer
      println(accumulator.size)


//      indexActor ! DoIndex(buffer)
    case IndexFinished(url) =>
      println(s"indexing finished $url")
    case _ =>
      print("")
  }

}
