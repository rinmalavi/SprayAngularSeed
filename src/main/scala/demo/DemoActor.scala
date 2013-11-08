package demo

import akka.actor.Actor
import spray.routing._
import spray.http.MediaTypes._
import spray.httpx.SprayJsonSupport._

class DemoActor extends Actor with HttpService {
  def actorRefFactory = context

  def receive = runRoute(myroute)

  def getStrList(query: String): List[String] =
    "Zero" :: "One" :: "Two" :: query :: Nil

  import spray.json.DefaultJsonProtocol._

  val myroute = {
    path("getsomelistOfStrings") {
      get {
        parameters('query?) {
          case (Some(query)) =>
            complete {
              getStrList(query)
            }

          case None =>
            complete {
              Map("error" -> "Missing Parametar")
            }
        }
      } ~
        post {
          entity(as[String]){
            body => complete(body)
          }
        }
    } ~
      path("") {
        getFromResource("html/index.html")
      }
  }
}

