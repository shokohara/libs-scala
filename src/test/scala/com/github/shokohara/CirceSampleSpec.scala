package com.github.shokohara

import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import org.scalatest._

class CirceSampleSpec extends FlatSpec with Matchers {
  "Circe" should "do" in {
    CirceSample.foo.asJson.noSpaces shouldBe """{"Qux":{"i":13,"d":14.0}}"""
    decode[Foo](CirceSample.foo.asJson.noSpaces).right.get shouldBe CirceSample.foo
    decode[Foo](CirceSample.foo.asJson.spaces4).right.get shouldBe CirceSample.foo
  }
}
