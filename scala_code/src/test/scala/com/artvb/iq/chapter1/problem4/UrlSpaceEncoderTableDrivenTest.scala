package com.artvb.iq.chapter1.problem4

import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by artburkart on 10/27/14.
 */
class UrlSpaceEncoderTableDrivenTest extends FlatSpec with Matchers {
  "urlSpaceEncoder" should "match the expected url encoding" in {
    val testTable = Table(
      ("str", "trueLength"),
      ("hello world  ", 11),
      ("", 0),
      ("   ", 1),
      ("a b c    ", 5),
      ("a b c do      ", 8),
      (" a b c do        ", 9)
    )

    forAll (testTable) { (str: String, trueLength: Int) =>
      UrlSpaceEncoder.urlSpaceEncoder(str, trueLength) should be ((str take trueLength).replace(" ", "%20"))
    }
  }
}