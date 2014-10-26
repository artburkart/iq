package com.artvb.iq.chapter1.problem3

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by artburkart on 10/25/14.
 */
class PermutationsEqualTableDrivenTest extends FlatSpec with Matchers {
  "permutationsEqual" should "match the expected value" in {
    val testTable = Table(
      ("strA", "strB", "expected"),
      ("aba", "baa", true),
      ("aaa", "aaa", true),
      ("", "", true),
      ("a", "a", true),
      ("aab", "baa", true),
      ("aabc", "baac", true),
      ("ab", "cb", false),
      ("aaba", "aab", false),
      ("bbb", "aaa", false)
    )

    forAll (testTable) { (strA: String, strB: String, expected: Boolean) =>
      PermutationsEqual.permutationsEqual(strA, strB) should be (expected)
    }
  }
}