package leetcode.easy

//region Problem

/**
 * Given an integer `num` return the number of digits in `num` that divide `num`.
 *
 * An integer `val` divides `num` if `nums % val == 0`.
 */

//endregion

//region Test cases

/**
 * Input: num = 7
 * Output: 1
 *
 * Input: num = 121
 * Output: 2
 */

//endregion

//region Solution

private fun main() {
    println(countDigitsOptimized(num = 7))
    println(countDigitsOptimized(num = 121))
}

fun countDigits(num: Int): Int {
    var tempNumber = num
    val digitArray = arrayListOf<Int>()
    var resultCount = 0

    while (tempNumber > 0) {
        digitArray.add(tempNumber % 10)
        tempNumber /= 10
    }

    for (digit in digitArray) {
        if (num % digit == 0) {
            resultCount++
        }
    }

    return resultCount
}

fun countDigitsOptimized(num: Int): Int {
    return num.toString().map { it.digitToInt() }.fold(0) { acc, i ->
        if (num % i == 0) {
            acc + 1
        } else {
            acc
        }
    }
}

//endregion