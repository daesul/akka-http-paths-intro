package com.example

import _root_.akka.actor.ActorSystem
import _root_.akka.http.scaladsl.Http
import _root_.akka.http.scaladsl.server.Directives._
import _root_.akka.stream.ActorMaterializer
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}


object Main extends App with OtherPaths {
  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()



  val paths = {
    concisePath("my-path") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>GET My-Path</h1>"))
      } ~
      post {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>POST My-Path</h1>"))
      } ~
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>DEFAULT My-Path</h1>"))
    } ~
      path("my-other-path1") {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>My-Other-Path1</h1>"))
      } ~
      otherPathWithSubPaths
  }

  Http().bindAndHandle(paths, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
}

