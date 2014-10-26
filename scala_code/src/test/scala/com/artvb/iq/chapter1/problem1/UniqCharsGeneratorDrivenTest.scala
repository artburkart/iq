package com.artvb.iq.chapter1.problem1

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by artburkart on 10/23/14.
 */
class UniqCharsTableDrivenTest extends FlatSpec with Matchers {
  "UniqChars" should "match the expected values" in {
    val testStrings = Table(
      ("str", "method", "expected"),
      ("", UniqChars.Bit, Option(false)),
      ("", UniqChars.Set, Option(false)),
      ("", UniqChars.Sort, Option(false)),
      ("a", UniqChars.Bit, Option(true)),
      ("a", UniqChars.Set, Option(true)),
      ("a", UniqChars.Sort, Option(true)),
      ("ab", UniqChars.Bit, Option(true)),
      ("ab", UniqChars.Set, Option(true)),
      ("ab", UniqChars.Sort, Option(true)),
      ("aba", UniqChars.Bit, Option(false)),
      ("aba", UniqChars.Set, Option(false)),
      ("aba", UniqChars.Sort, Option(false)),
      ("aaba", UniqChars.Bit, Option(false)),
      ("aaba", UniqChars.Set, Option(false)),
      ("aaba", UniqChars.Sort, Option(false)),
      ("baa", UniqChars.Bit, Option(false)),
      ("baa", UniqChars.Set, Option(false)),
      ("baa", UniqChars.Sort, Option(false)),
      ("abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.Bit, Option(true)),
      ("abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.Set, Option(true)),
      ("abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.Sort, Option(true)),
      ("abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.Bit, Option(false)),
      ("abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.Set, Option(false)),
      ("abcdefghijklmnopqrstuvwxyz{|}~_`abcdefghijklmnopqrstuvwxyz{|}~_`", UniqChars.Sort, Option(false)),
      // The Bit method cannot be used with these tests because the char values are out of range
      ("!🛅", UniqChars.Bit, None),
      ("!🛅", UniqChars.Set, Option(true)),
      ("!🛅", UniqChars.Sort, Option(true)),
      ("!🛅🛅", UniqChars.Bit, None),
      ("!🛅🛅", UniqChars.Set, Option(false)),
      ("!🛅🛅", UniqChars.Sort, Option(false))
    )

    forAll (testStrings) { (str: String, method: Int, expected: Option[Boolean]) =>
      UniqChars.uniqChars(str, method) should be (expected)
    }
  }
}
