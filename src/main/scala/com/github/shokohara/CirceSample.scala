package com.github.shokohara

sealed trait Foo

case class Bar(xs: List[String]) extends Foo

case class Qux(i: Int, d: Option[Double]) extends Foo

object CirceSample {
  val foo: Foo = Qux(13, Some(14.0))
}
