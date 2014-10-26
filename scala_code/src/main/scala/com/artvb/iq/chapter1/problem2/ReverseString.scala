package com.artvb.iq.chapter1.problem2

/**
 * Created by artburkart on 10/25/14.
 */
object ReverseString {
  /** Reverses a given String
    *
    * @param str the given String
    * @return the given String reversed
    */
  def reverseString(str: String) = {
    def reverseString1(l: List[Char], result: List[Char] = Nil): List[Char] = l match {
      case Nil => result
      case (h :: t) => reverseString1(t, h :: result)
    }
    reverseString1(str.toList).mkString

    // This probably would have been a better solution (but I don't know Scala)
    // (for(i <- str.length until 0 by -1) yield str(i-1)).mkString
  }
}
