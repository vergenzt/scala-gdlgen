package scard.server

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.FSM
import akka.actor.Props
import akka.actor.ActorLogging

/**
 * Scard messages
 */
private[scard]
object Msg {
  case class Connect(playerName: String)
  case class ConnectConfirmed(playerName: String)
  case object PrintPlayers
}

/**
 * ScardServer states
 */
private[server]
trait State extends Enumeration {
}

class ScardServer extends Actor
	with FSM[State, List[String]]
	with ActorLogging {
  
  /**
   * Start the server waiting for players to join.
   */
  startWith(State.Waiting, List())
  
  when(Waiting) {
    // a new player connected
    case Event(Msg.Connect(name), _) =>
      sender ! Msg.ConnectConfirmed(name)
      log info ("Player \"" + name + "\" connected.")
      stay using (name :: stateData)

    // print the currently connected players
    case Event(Msg.PrintPlayers, _) =>
      stateData match {
        case Nil => log info ("No players connected.")
        case _ =>
          log info ("Currently connected players:")
          stateData foreach {name => log info ("  " + name)}
      }
      goto(nextStateName)
  }
  
}

object Launcher extends App {
  val system = ActorSystem("ScardServerSystem")
  val scardServer = system.actorOf(Props[ScardServer], name = "scard-server")
}
