package com.sample.scaladev.fpprinciples

import com.sample.scaladev.coursera.fpprinciples.Rational
import org.scalatest.FunSuite

/**
  * Simple test to get familiar with Scalatest.
  */
class SimpleScalaTest extends FunSuite {

  test("Simple Test 001") {
    assert(1 > 0, "1 should be greater than 0")
  }

  test("Test for Rational 11/17") {
    val firstRational = new Rational(11, 17)

    assert(firstRational.numer == 11, "Numerator is 11")
    assert(firstRational.denom == 17, "Denominator is 11")
  }

  test("Precondition fails when denominator is 0") {
    val iae = intercept[IllegalArgumentException] {
      new Rational(1, 0)
    }

    println(s"Exception: $iae")
    assert(iae != null, "The precondition actually throws an IllegalArgumentException")
  }
}
