package de.mannodermaus.aoc17.day1

import de.mannodermaus.aoc17.util.printSolution
import de.mannodermaus.aoc17.util.printTitle
import de.mannodermaus.aoc17.util.readResource

private val part1: (String) -> Int = { line ->
  val chars = line.toCharArray()

  chars
      // Compare each digit to its right neighbor, wrapping around at the end
      .filterIndexed { index, char -> char == chars[(index + 1) % chars.size] }
      // Get the actual digit from the Char, not its ASCII value
      .sumBy { Character.digit(it, 10) }
}

private val part2: (String) -> Int = { line ->
  val chars = line.toCharArray()
  assert(chars.size % 2 == 0) { "They said the list's length was even :(" }

  // Index offset used for comparisons
  val offset = chars.size / 2

  chars
      // Compare each digit to the one located at the given offset, wrapping around at the end
      .filterIndexed { index, char -> char == chars[(index + offset) % chars.size] }
      // Get the actual digit from the Char, not its ASCII value
      .sumBy { Character.digit(it, 10) }
}

fun main(args: Array<String>) {
  printTitle(day = 1, title = "Inverse Captcha")
  val input = readResource("day1.txt")

  printSolution(1) {
    input.map(part1).forEach { println(it) }
  }

  printSolution(2) {
    input.map(part2).forEach { println(it) }
  }
}
