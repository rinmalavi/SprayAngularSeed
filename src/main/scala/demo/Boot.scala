package demo

import akka.actor.{ ActorSystem, Props }

object Boot extends App{

  implicit val system = ActorSystem("on-spray-can")

  akka.io.IO(spray.can.Http) ! spray.can.Http.Bind(system.actorOf(Props[DemoActor], "demo-services"), interface = "localhost", port = 1111)
}

/*
  startServer(interface = "localhost", port = 1111) {
    path("") {
      getFromResource("html/index.html")
    }
  }
*/
