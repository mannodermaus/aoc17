package de.mannodermaus.aoc17.day2

import de.mannodermaus.aoc17.util.printSolution
import de.mannodermaus.aoc17.util.printTitle
import de.mannodermaus.aoc17.util.readResource

fun main(args: Array<String>) {
  printTitle(day = 2, title = "Corruption Checksum")
  val input = readResource("day2.txt")
      // Split each line on whitespace
      .map { line -> line.split(Regex("\\W+")) }
      .filter { it.isNotEmpty() }
      // Convert each cell to a number
      .map { tokens -> tokens.map { it.toInt() } }

  printSolution(1) {
    // Calculate the biggest difference for each line & sum it up
    println(input
        .map { numbers -> numbers.max()!! - numbers.min()!! }
        .sum())
  }

  printSolution(2) {
    println(input
        // For early detection, start with the biggest number & work downwards
        .map { numbers -> numbers.sortedDescending() }
        .map { numbers ->
          val pair = numbers
              // Isolate each item from the list & pair it against the remaining rest (Pair<Int, List<Int>>)
              .mapIndexed { index, _ -> numbers[index] to numbers.slice((index + 1) until numbers.size).sorted() }
              // Create pairs of values (List<Pair<Int, Int>>)
              .flatMap { pair -> pair.second.map { pair.first to it } }
              // Find the first evenly divisible pair
              .first { it.first % it.second == 0 }
          // Actually perform that division
          pair.first / pair.second
        }
        .sum())
  }
}
