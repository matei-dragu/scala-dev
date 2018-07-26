package com.sample.scaladev.coursera.fpprinciples

/**
  * Scala Main object - program entry point using the App trait.
  */
object ObjectExtendsApp extends App {

  println("Scala application entry point using the App trait")

  val rationalOne = new Rational(11, 13)
  val rationalTwo = new Rational(17, 19)

  try {
    // Division by zero?
    new Rational(21, 0)
  } catch {
    case iae: IllegalArgumentException => println(s"IAE caught: $iae")
  }

  println(rationalOne)
  println(s"rationalOne.numer = ${rationalOne.numer}")
  println(s"rationalOne.denom = ${rationalOne.denom}")

  println(rationalTwo)
  println(new Rational(111))
}
