package com.timvergenz.scard.api

abstract trait CardGame {
  type Card
  type Info

  object deal {
    def apply(n: Int) = this
    def from(deck: Deck[Card]) = this
    def to(hand: Hand) = this
  }

  object inform {
    def apply(p: Player) = this
    def of(i: Info) = this
  }
}