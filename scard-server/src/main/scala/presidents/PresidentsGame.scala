
package presidents

import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.FSM
import scard.server.Game

object Msg {
  case class PlayerConnected(name: String)
}

private[presidents]
object State {
  case object WaitForPlayers
  case object GameStart
  case object RoundStart
  case object InRound
}

case class Player(name: String)

private[presidents]
case class Data(
	    val players: List[Player],
	    val hands: Map[Player, Option[Set[String]]]
	) {
  
}

class PresidentsGame extends Game
	with FSM[Any, Data] {
  
  import State._
  
  startWith(State.WaitForPlayers, new Data(Nil, Map()))

  when(State.WaitForPlayers) {
    case Event(Msg.PlayerConnected(name), _) =>
      stay
  }
  
  onTransition {
    case _ -> RoundStart =>
      // deal cards
      // request exchanges if necessary
      goto(InRound)
    
    case _ -> InRound =>
      
  }
  
}