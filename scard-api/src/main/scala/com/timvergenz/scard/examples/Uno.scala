package com.timvergenz.scard.examples.uno

import com.timvergenz.scard.api

class Uno extends api.CardGame {

}

sealed trait Color
case object Red extends Color
case object Blue extends Color
case object Green extends Color
case object Yellow extends Color

sealed trait Card
sealed trait ColoredCard extends Card {
  def color: Color
}
case class Number(val n: Int, val color: Color) extends ColoredCard
case class Skip(val color: Color) extends ColoredCard
case class DrawTwo(val color: Color) extends ColoredCard
case class Reverse(val color: Color) extends ColoredCard
sealed trait WildCard extends Card
case class Wild extends WildCard
case class WildDrawFour extends WildCard

class Deck extends api.Deck[Card] {
  
  
}
