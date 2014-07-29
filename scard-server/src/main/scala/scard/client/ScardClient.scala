
package scard.client

import akka.actor.ActorSelection.toScala
import akka.actor.ActorSystem
import scard.server.Msg

object ScardClient extends App {

  println("STARTING")
  val system = ActorSystem("GreetingSystem-1")
  val server = system.actorSelection("akka.tcp://ScardServerSystem@127.0.0.1:2552/user/scard-server")

  while (readLine() != null) server ! Msg.Connect("Tim")

}