package com.timvergenz.scard.api

trait Player {
  class Choice[O] {
    def suchThat(f: O => Boolean): O = ???
    def fromOptions[D](opts: Map[O, D]): O = ???
  }
  def choose[O] = new Choice[O]
}