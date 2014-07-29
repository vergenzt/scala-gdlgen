package com.timvergenz.scard.examples.ninetynineorbust

import com.timvergenz.scard.api

class NinetyNineOrBust extends api.CardGame {
  val deck = new Deck

}

class Player extends api.Player {
  
}

sealed trait Card
case class Number(val n: Int)
case class Reverse
case class StayTheSame
case class NinetyNine
case class Minus10

class Deck extends api.Deck {
  
  
}
