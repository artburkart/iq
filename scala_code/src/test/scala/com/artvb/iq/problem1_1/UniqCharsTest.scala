package com.artvb.iq.problem1_1

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by artburkart on 10/22/14.
 */
class UniqCharsTest extends FlatSpec with Matchers {
  "Sort method" should "return false" in {
    UniqChars.uniqChars("worldo", UniqChars.Sort) should be (Option(false))
    UniqChars.uniqChars("", UniqChars.Sort) should be (Option(false))
  }
  "Sort method" should "return true" in {
    UniqChars.uniqChars("world", UniqChars.Sort) should be (Option(true))
    UniqChars.uniqChars("ab", UniqChars.Sort) should be (Option(true))
  }
  "Mask method" should "return true" in {
    UniqChars.uniqChars("world", UniqChars.Set) should be (Option(true))
  }
}
