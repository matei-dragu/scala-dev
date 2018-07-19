package com.sample.scaladev.safari.learningscala

object Ch6Collections {

  def main(args: Array[String]): Unit = {
    println("Chapter 6")

    val numbers = List(3, 5, 7, 11)
    println(numbers)
    var total = 0
    for (i <- numbers) {
      total += i
    }
    println(s"total: $total")

    val colors = List("red", "green", "blue")
    for (color <- colors) {
      println(color)
    }

    colors.foreach(col => println(s"Color: $col"))

    val sizes: List[Int] = colors.map(currColor => currColor.size)
    println(sizes)

    val numbersSum: Int = numbers.reduce((a, b) => a + b)
    println(numbersSum)

    val unique = Set(10, 20, 30, 10, 10, 20)
    println(unique)

    val colorMap = Map(
      "red" -> 0xFF0000,
      "green" -> 0xFF00,
      "blue" -> 0xFF)
    println(colorMap)

    val redRGB = colorMap("red")
    println(redRGB)

    for (pairs <- colorMap) { println(pairs) }

    println(numbers.head)
    println(numbers.tail)

  }

}
