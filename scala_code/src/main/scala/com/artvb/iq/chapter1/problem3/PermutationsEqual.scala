package com.artvb.iq.chapter1.problem3

import scala.collection.immutable.HashMap

/**
 * Created by artburkart on 10/25/14.
 */
object PermutationsEqual {
  def permutationsEqual(strA: String, strB: String): Boolean = {
    @annotation.tailrec
    def createCharMap(l: List[Char], m: HashMap[Char, Int] = new HashMap[Char, Int](), n: Int): HashMap[Char, Int] = l match {
      case (Nil) => m
      case (h :: t) => m.get(h) match {
        case (None) => if (n == 0) m else createCharMap(t, m + (h -> 1), n - 1)
        case Some(i) => if (n == 0 && i - 1 < 0) m else if (n == 0) createCharMap(t, m + (h -> (i - 1)), n) else createCharMap(t, m + (h -> (i + 1)), n - 1)
      }
    }
    if ((strA.length() != strB.length()))
      false
    else
      createCharMap((strA + strB).toList, new HashMap[Char, Int](), strA.length()).values.filter(_ != 0).toList.length == 0
  }
}
