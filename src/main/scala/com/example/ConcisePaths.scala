package com.example

import akka.http.scaladsl.server.Directives._

trait ConcisePaths {

  def concisePath(segment: String ) = {
    (pathPrefix(segment) & pathEndOrSingleSlash)
  }
}
