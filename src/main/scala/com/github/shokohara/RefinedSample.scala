package com.github.shokohara

import eu.timepit.refined.W
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.boolean._
import eu.timepit.refined.numeric._

class RefinedSample {

  true: Refined[Boolean, True]
//  true :Refined[Boolean, Not[True]]
//  false :Refined[Boolean, Not[True]]
//  false :Refined[Boolean, False]
  true: Refined[Boolean, True And True]
//  false :Refined[Boolean, True And False]
  true: Refined[Boolean, True Or True]

  type NL0ANG8 = Not[Less[W.`0`.T]] And Not[Greater[W.`8`.T]]
  0: Refined[Int, NL0ANG8]
  1: Refined[Int, NL0ANG8]
  7: Refined[Int, NL0ANG8]
  8: Refined[Int, NL0ANG8]
  List(0, 1, 2, 3, 4, 5, 6, 7, 8): List[Refined[Int, NL0ANG8]]
//  List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9): List[Refined[Int, NL0ANG8]]
//  List(0, 1, 2, 3, 4, 5, 6, 7, 8).map(_ + 0): List[Refined[Int, NL0ANG8]]

  type GE0ALE8 = GreaterEqual[W.`0`.T] And LessEqual[W.`8`.T]
  List(0, 1, 2, 3, 4, 5, 6, 7, 8): List[Refined[Int, GE0ALE8]]
//  List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9): List[Refined[Int, GE0ALE8]]
}
