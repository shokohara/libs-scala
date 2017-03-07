package com.github.shokohara

import scalaz._
import scalaz.std.function._

import scalaz.Scalaz._

class MapTupleScalaz {

  val f = (_:Int).toString
  (0,1).bimap(f, f) : (String, String)

  val join : List[List[Int]] => List[Int] = _.join

  val arrowf = Arrow[Function1].arr(f)

  val f2 = *** join

}
