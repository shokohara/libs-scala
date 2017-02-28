package com.github.shokohara

import scalaz._
import scalaz.Scalaz._

class ScalazSequence {

  (1.some :: Nil).sequence
  (1.some :: Nil).map(_.map(_ + 1))
  val xs: List[Either[String, Int]] = List(Right(1), Right(2))
  xs.sequenceU: Either[String, List[Int]]
  xs.sequence[Either[String, ?], Int]: Either[String,List[Int]]

  val xs2: List[String \/ Int] = List(1.right, 2.right)
  xs2.sequenceU: String \/ List[Int]
  xs2.sequence[String \/ ?, Int]: String \/ List[Int]
  val xs3: List[String \/ Int] = List(1.right, 2.right)
//  xs2.sequence1
//  xs2.sequence1U
//  xs2.sequenceF_
//  xs2.sequenceS_
//  xs2.bisequence
//  xs2.cosequence
//  xs2.bisequenceU
}
