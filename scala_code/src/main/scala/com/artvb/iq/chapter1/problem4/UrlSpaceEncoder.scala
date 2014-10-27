package com.artvb.iq.chapter1.problem4

/**
 * Created by artburkart on 10/27/14.
 */
object UrlSpaceEncoder {
  /** URL encodes spaces as "%20" and trims off the extra spaces on the end
    *
    * @param str given String to URL encode spaces in
    * @param trueLength given length of String to URL encode
    * @return returns String with spaces URL encoded
    */
  def urlSpaceEncoder(str: String, trueLength: Int): String = {
    def urlSpaceEncoder1(l: List[Char], acc: String = ""): String = l match {
      case (Nil) => acc
      case (h :: t) => if (h == ' ') urlSpaceEncoder1(t, acc + "%20") else urlSpaceEncoder1(t, acc + h)
    }
    urlSpaceEncoder1(str.toList take trueLength)
  }
}
