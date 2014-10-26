package com.artvb.iq.chapter1.problem2

import org.scalacheck._
import org.scalatest.prop.GeneratorDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}
import scala.util.Random

/**
 * Created by artburkart on 10/25/14.
 */
class ReverseStringGeneratorDrivenTest extends FlatSpec with Matchers {
  "reverseString" should "match the expected value" in {
    @annotation.tailrec
    def randomString(n: Int, list: List[Char]): List[Char] = {
      if (n == 1) Random.nextPrintableChar :: list
      else randomString(n-1, Random.nextPrintableChar :: list)
    }
    val randomStringGenerator = for (i <- Gen.choose(0, 100)) yield randomString(Random.nextInt(100), Nil).mkString
    val randomParamsGenerator = for (s <- randomStringGenerator) yield (s, s.reverse)

    forAll (randomParamsGenerator) { (params) =>
      val str = params.asInstanceOf[(String, String)]._1
      val expected = params.asInstanceOf[(String, String)]._2
      ReverseString.reverseString(str) should be (expected)
    }
  }
}
