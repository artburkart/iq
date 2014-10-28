package com.artvb.iq.chapter1.problem5

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by artburkart on 10/28/14.
 */
class StringCompressorTableDrivenTest extends FlatSpec with Matchers {
  "compress" should "match expected value" in {
    val testTable = Table(
      ("", ""),
      ("ab", "ab"),
      ("abc", "abc"),
      ("aaa", "a3"),
      ("hello", "hello"),
      ("hellllllo", "h1e1l6o1"),
      ("hheelloo", "hheelloo"),
      ("hheeelloo", "h2e3l2o2")
    )

    forAll (testTable) { (str: String, expected: String) =>
      StringCompressor.compress(str) should be (expected)
    }
  }
}