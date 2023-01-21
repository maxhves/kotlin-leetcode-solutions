package hackerrank

import java.math.BigInteger

fun miniMaxSum(arr: Array<Int>): Unit {
    // Problem
    // Given 5 positive integers;
    // - Find the minimum and maximum values that can be calculated by summing exactly 4 of the 5 integers
    // - Print the respective minimum and maximum values

    // Basic solution
    val sortedArray = arr.sortedArray().map { it.toLong() }

    val minimumArray = sortedArray.slice(0..3)
    val maximumArray = sortedArray.slice(1..4)

    println("${minimumArray.sum()} ${maximumArray.sum()}")

    // Input
    // 256741038 623958417 467905213 714532089 938071625

    // Output
    // 2063136757 2744467344
}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum(arr)
}