package hackerrank

import java.math.BigInteger
import java.util.*

// Initial
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

// Better
fun miniMaxSum2(arr: Array<Int>) {
    var sum: Long = arr[0].toLong()
    var min = arr[0]
    var max = arr[0]

    for (i in 1 until arr.size) {
        val current = arr[i]

        sum += current

        // If min is bigger than the current item then it isn't the smallest
        if (min > current) {
            min = current
        }

        // If max is smaller than the current item then it isn't the biggest
        if (max < current) {
            max = current
        }
    }

    println("${sum - max} ${sum - min}")
}

fun main(args: Array<String>) {

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    miniMaxSum2(arr)
}