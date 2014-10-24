package com.artvb.iq.problem1_1

import scala.collection.immutable.{HashMap, HashSet}

/**
 * Created by artburkart on 10/22/14.
 */
object UniqChars {

  /** Selects algorithm for determining redundancy in given String
   *
   * @param str String to check whether only contains unique chars
   * @param method the algorithm to use when determining character uniqueness
   * @return Some(true) iff String only contains unique characters,
    *         Some(false) iff String contains duplicate characters,
    *         None iff String is invalid for chosen method
   */
  def uniqChars(str: String, method: Int) = method match {
    case 1 => UniqChars.method1(str)
    case 2 => UniqChars.method2(str)
    case 3 => UniqChars.method3(str)
    case _ => None
  }

  /** Sorts String to check for redundancy contained chars
    *
    * @param str String to check whether contains only unique chars
    * @return Some(true) iff String contains unique characters,
    *         Some(false) otherwise
    */
  private def method1(str: String) = {
    @annotation.tailrec
    def helper(l: List[Char]): Option[Boolean] = l match {
      case List(a) => Some(true)
      case (h1 :: h2 :: t) => if (h1 == h2) Some(false) else helper(h2 :: t)
    }
    if (str.length() == 0) Some(false) else helper(str.toList.sorted)
  }

  /** Uses a HashSet to check for redundancy of chars in given String
    *
    * @param str String to check whether contains only unique chars
    * @return Some(true) iff String contains unique characters,
    *         Some(false) otherwise
    */
  private def method2(str: String) = {
    @annotation.tailrec
    def helper(l: List[Char], s: Set[Char]): Option[Boolean] = l match {
      case (Nil) => Some(true)
      case (h :: t) => if (s(h)) Some(false) else helper(t, s + h)
    }
    if (str.length() == 0)
      Some(false)
    else
      helper(str.toList, new HashSet[Char])
  }

  /** Uses bit twiddling to check for redundancy in given String
    *
    * Note: This function is fugly. It's my first attempt and I'm new to Scala,
    * so I will need to come back and fix this later. But I really want to look
    * at new problems, so I'm moving on.
    *
    * @param str String to check for redundancy of chars
    * @return None if difference between max ordinal value of char and
    *         min ordinal value of char in String is larger than 31
    *         Some(true) if there are no duplicate characters in given String
    *         Some(false) if given String contains duplicate characters
    */
  private def method3(str: String) = {
    val maxChar = if (str.length() > 0)
      str.toList.maxBy(c => c.toInt).toInt
    else 0
    val minChar = if (str.length() > 0)
      str.toList.minBy(c => c.toInt).toInt
      else 0
    val diff = maxChar - minChar

    @annotation.tailrec
    def helper(l: List[Char], mask: Int): Option[Boolean] = l match {
      case (Nil) => Some(true)
      case (h :: t) => if (((1 << h.toInt - minChar) & mask) > 0)
        Option(false)
      else
        helper(t, (mask | 1 << h.toInt - minChar))
    }

    if (str.length() == 0)
      Some(false)
    else if (diff > UniqChars.maxIntSize - 1)
      None
    else helper(str.toList, 0)
  }

  private val maxIntSize = 32

  val Sort = 1
  val Set = 2
  val Bit = 3
}
