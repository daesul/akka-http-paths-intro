package com.example

import _root_.akka.actor.ActorSystem
import _root_.akka.http.scaladsl.Http
import _root_.akka.http.scaladsl.server.Directives._
import _root_.akka.stream.ActorMaterializer


object Main extends App with OtherPaths {
  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()



  val paths = {
    concisePath("my-path") {
      get {
        complete("GET My-Path")
      } ~
      post {
        complete("POST My-Path")
      } ~
      complete("DEFAULT My-Path")
    } ~
    path("my-other-path1") {
      complete("My-Other-Path1")
    } ~
    otherPathWithSubPaths
  }

  Http().bindAndHandle(paths, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
}

