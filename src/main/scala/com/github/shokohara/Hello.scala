package com.github.shokohara

trait Greeting {
  lazy val greeting: String = "hello"
}

object Hello extends Greeting
