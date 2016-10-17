package com.example

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._

trait OtherPaths extends ConcisePaths {

  val otherPathWithSubPaths = {
    pathPrefix("my-other-path2") {
      pathEndOrSingleSlash {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>my-other-path2/</h1>"))
      } ~
        path("sub1") {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>sub1/</h1>"))
        } ~
        concisePath("sub2") {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>sub2/</h1>"))

        }
    }
  }
}

