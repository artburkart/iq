package com.artvb.iq.problem1_1

import org.scalatest._

/**
 * Created by artburkart on 10/22/14.
 */
class UniqCharsTest extends FlatSpec with Matchers {
  "method1" should "return false" in {
    UniqChars.method1("worldo") should be (false)
    UniqChars.method1("") should be (false)
  }
  "method1" should "return true" in {
    UniqChars.method1("world") should be (true)
  }
}
