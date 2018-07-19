package com.sample.scaladev.safari.learningscala

object Ch5FirstClassFunctions {

  def main(args: Array[String]): Unit = {
    val maximize: (Int, Int) => Int = max

    println(maximize)
    println(maximize(20, 30))
    println(maximize(47, 30))

    val doubler = (x: Int) => x * 2
    println(doubler)
    println(doubler(57))

    // placeholder syntax
    val doublerPlaceholder : Int => Int = _ * 2

  }

  private def max(a: Int, b: Int): Int = {
    if (a > b)
      a
    else
      b
  }

  private def sumParamList(x: Int)(y: Int): Int = {
    x + y
  }

}
