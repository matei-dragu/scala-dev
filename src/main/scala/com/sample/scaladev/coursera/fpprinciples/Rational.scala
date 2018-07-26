package com.sample.scaladev.coursera.fpprinciples

class Rational(x: Int, y: Int) {
  require(y != 0, "The denominator must be nonzero!") // <=== PRECONDITION

  def this(x: Int) = { // <=== SECOND CONSTRUCTOR
    this(x, 1)
  }

  val numer = x
  val denom = y

  override def toString = s"Rational(numer=$numer, denom=$denom)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Rational]

  override def equals(other: Any): Boolean = other match {
    case that: Rational =>
      (that canEqual this) &&
        numer == that.numer &&
        denom == that.denom
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(numer, denom)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
