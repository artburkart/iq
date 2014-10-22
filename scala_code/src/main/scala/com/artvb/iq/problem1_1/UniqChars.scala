package com.artvb.iq.problem1_1

import scala.annotation.tailrec
import scala.collection.immutable.HashSet

/**
 * Created by artburkart on 10/22/14.
 */
object UniqChars {
  def method1(str: String) = {
    @tailrec
    def helper(l: List[Char], s: Set[Char]): Boolean = l match {
      case (Nil)=> true
      case (h :: t) => if (s(h)) false else helper(t, s + h)
    }
    if (str.length() == 0) false else helper(str.toList, new HashSet[Char])
  }
}
