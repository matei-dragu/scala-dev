package com.sample.scaladev.safari.learningscala

object Ch3ExpressionsAndConditionals {

  def main(args: Array[String]): Unit = {

    // The last expression in a block is the return value of the entire block
    val amount = {
      val x = 5 * 20
      x + 10 //  <--- this will be the return value
    }
    printf(f"amount: $amount\n")

    // expression blocks are nestable
    val nestedAmount = {
      val a = 1

      {
        val b = a * 2

        {
          val c = b + 4
          c // <--- return value of the current block
        }
      }
    }
    printf(f"nestedAmount: $nestedAmount\n")

    // -----------------------------------------------------------------------------------------------------------------

    val x = 10 // Int
    val y = 20 // Int

    val max = x > y  match {
      case true => x
      case false => y
    }
    printf(f"max - match: $max\n")


    val httpStatus = 500
    val httpMessage = httpStatus match {
      case 200 => "OK"
      case 400 =>
        println("ERROR - 400 line 1")
        println("ERROR - 400 line 2")
        println("ERROR - 400 line 3")

        "error400"

      case 500 =>
        println("ERROR - 500 line 1")
        println("ERROR - 500 line 2")
        println("ERROR - 500 line 3")
        println("ERROR - 500 line 4")

        "error500"
    }
    printf(f"httpStatus/httpMessage - match: $httpStatus/$httpMessage\n")

    // pattern alternatives => match for multiple expressions at the same time
    val dayOfWeek = "MON"
    val dayCategory = dayOfWeek match {
      case "MON" | "TUE" | "WED" | "THU" | "FRI" => "weekday"
      case "SAT" | "SUN" => "weekend"
      case otherValue =>  // <-- VALUE BINDING WILDCARD PATTERN
        println(s"Could not match input value: $otherValue")
        "UNKNOWN"
    }
    printf(f"dayOfWeek/dayCategory - match: $dayOfWeek/$dayCategory\n")

    // wildcard pattern matching
    val message = "UnknownMessage"
    val statusFromMessage = message match {
      case "OK" => 200
      case _ =>
        println(s"Could not match input value: $message")
        -1
    }
    println(s"statusFromMessage: $statusFromMessage")

    matchingWithPatternGuards("==> SYN")
    matchingWithPatternGuards("ACK-SYN")
    matchingWithPatternGuards("ACK")
    matchingWithPatternGuards("nope")

    println(matchingWithPatternVariables("InStr"))
    println(matchingWithPatternVariables(220D))
    println(matchingWithPatternVariables(110))
    println(matchingWithPatternVariables(330L))
    println(matchingWithPatternVariables(440F))

    // -----------------------------------------------------------------------------------------------------------------
    simpleForLoop()
    println(yieldForLoop())
    for (day <- yieldForLoop()) {
      print(day + ", ")
    }
    println()

    println(forLoopWithIteratorGuard())
    println(forLoopWithMultipleIteratorGuards())

    forLoopWithNestedIterators()
    println(forLoopWithValueBinding())
    whileLoop()
    doWhileLoop()
  }

  private def matchingWithPatternGuards(message: String): Unit = {
    // Matching with PATTERN GUARDS: value-binding pattern + if expression

    message match {
      case tcpFlag if tcpFlag.contains("SYN") => println(s"SYN flag contained in [$message]")
      case tcpFlag if tcpFlag.contains("ACK") => println(s"ACK flag contained in [$message]")
      case _ => println(s"neither SYN or ACK found in [$message]")
    }
  }

  private def matchingWithPatternVariables(input: Any): String = {
    // the matched expression is also casted to the right type

    input match {
      case s: String => s"STRING: '$s'"
      case d: Double => f"DOUBLE: $d%.2f"
      case f: Float => f"FLOAT: $f%.2f"
      case i: Int => s"INT: $i"
      case l: Long => s"LONG: $l"

      case _ => "unsupported input type"
    }
  }

  private def simpleForLoop(): Unit = {
    for (x <- 1 to 7) {
      println(s"Day $x:")
    }
  }

  private def yieldForLoop(): IndexedSeq[String] = {
    val strings: IndexedSeq[String] = for (x <- 1 to 7) yield {
      s"Day $x:"
    }

    strings
  }

  private def forLoopWithIteratorGuard(): IndexedSeq[Int] = {
    for(i <- 1 to 20 if i % 3 == 0) yield i
  }

  private def forLoopWithMultipleIteratorGuards(): IndexedSeq[Int] = {
    for(
      i <- 1 to 60
      if i % 3 == 0  // <-- Multiple if conditions (filters) can be used
      if i % 5 == 0  // <--
    ) yield i
  }

  private def forLoopWithNestedIterators(): Unit = {
    // total number of iterations: the product of the individual iterators
    for (
      x <- 1 to 5;
      y <- 1 to 4
    ) {
      print(s"($x,$y) ")
    }
    println()
  }

  private def forLoopWithValueBinding(): IndexedSeq[Int] = {
    for (
      i <- 0 to 8;
      pow = 1 << i // <-- value binding
    ) yield pow
  }

  private def whileLoop(): Unit = {
    var i = 10
    while (i > 0) {
      println(s"i: $i")
      i -= 1
    }
  }

  private def doWhileLoop(): Unit = {
    var i = 10
    do {
      println(s"i: $i")
      i -= 1
    } while (i > 0)
  }
}
