import akka.actor.{ActorSystem, PoisonPill, Props}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.language.postfixOps

object StartingPoint extends App {


//  val restartStrategy = OneForOneStrategy() {
//    case e: Exception =>
//      SupervisorStrategy.Restart
//  }

  val system = ActorSystem()
  val supervisor = system.actorOf(Props(new Supervisor(system)), name = "supervisor")

//  val routees = Vector[ActorRef](supervisor, parseActor, indexActor)

//  val router2 = system.actorOf(Props.empty.withRouter(SmallestMailboxPool(2, supervisorStrategy = restartStrategy)))

//  router2 ! DoIndex("http://www.ikea.com/nl/nl/catalog/categories/departments/")
//  /nl/nl/catalog/categories/departments/
  supervisor ! Start("http://www.ikea.com/nl/nl/catalog/categories/departments/eating/16044/")
  supervisor ! Start("http://www.ikea.com/nl/nl/catalog/categories/departments/eating/18865/")

  Await.result(system.whenTerminated, 10 minutes)

  supervisor ! PoisonPill
  system.terminate
}
