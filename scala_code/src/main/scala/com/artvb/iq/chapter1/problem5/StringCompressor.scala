package com.artvb.iq.chapter1.problem5

/**
 * Created by artburkart on 10/27/14.
 */
object StringCompressor {
  /** Compresses String with simple algorithm of
    * representing repeated occurrences with numbers
    *
    * Note: If the String cannot be compressed, then
    * the original input String is returned instead
    *
    * Example:
    *
    * input: hheeelloo  output: h2e3l2o2
    * input: aaabbb     output: a3b3
    * input: hello      output: hello
    * input: aa         output aa
    * input: hheelloo   output: hheelloo
    *
    * @param str String to compress
    * @return compressed String
    */
  def compress(str: String): String = {
    @annotation.tailrec
    def compress1(l: List[Char], n: Int = 0, acc: String = ""): String = l match {
      case (Nil) => acc
      case (h :: Nil) => acc + h + (n + 1)
      case (h1 :: h2 :: t) => if (h1 == h2) compress1(h2 :: t, n + 1, acc) else compress1(h2 :: t, 0, acc + h1 + (n + 1))
    }
    val compressed = compress1(str.toList)
    if (compressed.length() < str.length()) compressed else (str)
  }
}
