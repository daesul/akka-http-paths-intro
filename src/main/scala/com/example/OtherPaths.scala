package com.example

import akka.http.scaladsl.server.Directives._

trait OtherPaths extends ConcisePaths {

  val otherPathWithSubPaths = {
    pathPrefix("my-other-path2") {
      pathEndOrSingleSlash {
        complete("my-other-path2/")
      } ~
      path("sub1") {
          complete(">sub1")
      } ~
      concisePath("sub2") {
        complete("sub2")
      }
    }
  }
}

