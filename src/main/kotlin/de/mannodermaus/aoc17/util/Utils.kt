package de.mannodermaus.aoc17.util

fun readResource(resource: String) = String::class.java
    .getResourceAsStream("/${resource.dropWhile { it == '/' }}")
    .bufferedReader(charset = Charsets.UTF_8)
    .readLines()
    .filter { it.isNotEmpty() }

fun printTitle(day: Int, title: String) {
  println("-".repeat(title.length + 4))
  println("| Day $day:")
  println("| \"${title.toUpperCase()}\"")
  println("-".repeat(title.length + 4))
  println()
}

fun printSolution(part: Int, block: () -> Unit) {
  println("> --- Part $part ---")
  block()
  println("< --------------")
  println()
}
