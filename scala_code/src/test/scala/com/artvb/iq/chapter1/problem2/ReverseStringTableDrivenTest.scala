package com.artvb.iq.chapter1.problem2

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by artburkart on 10/25/14.
 */
class ReverseStringTableDrivenTest extends FlatSpec with Matchers {
  // TODO(arthurb): Figure out that dastardly test generator.
  // Maybe wait until IntelliJ does correct code highlighting, or
  // until I start coding something in Scala without an IDE
  "reverseString" should "match the expected value" in {
    val testTable = Table("str", "a", "aa", "ab", "aba", "",
      "abcdefghijklmnopqrstuvwxyz",
      "abcdeffghijklimn=-0987654321!@#$%^&*()_oppqrstuvwxyz")
    forAll (testTable) { (s) =>
      ReverseString.reverseString(s) should be (s.reverse)
    }
  }
}
