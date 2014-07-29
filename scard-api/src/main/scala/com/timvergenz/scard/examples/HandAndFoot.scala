package com.timvergenz.scard.examples.handandfoot

import com.timvergenz.scard.api

class Player extends api.Player {
  var hand = new api.Hand
  var foot = new api.Hand
}

class HandAndFoot extends api.CardGame {

  val mainDeck = (new api.Deck with api.Jokers) * 4
  val players: Seq[Player] = Seq()

  // each player is dealt a hand and a foot of 13 cards each
  players foreach { player =>
    deal(13) from (mainDeck) to (player.hand)
    deal(13) from (mainDeck) to (player.foot)
  }

  // each player chooses which they want to be their hand and
  // which they want to be their foot
  players foreach { player =>
    val choice = player.choose[String] fromOptions Map(
      "hand" -> player.hand,
      "foot" -> player.foot)
    choice match {
      case "hand" =>
      case "foot" =>

    }

  }

}