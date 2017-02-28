package com.github.shokohara

import scalaz.Monoid
import scalaz.Scalaz._

class ScalazTraverse {
  Monoid[Int].applicative.traverse(List(1, 2, 3)) {_ + 1}
}
