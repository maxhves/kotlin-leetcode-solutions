package leetcode.easy

//region Problem

/**
 * Given a positive integer `n`, find the sum of all integers in the range `[1, n]` inclusive
 * that are divisible by `3`, `5`, or `7`.
 *
 * Return an integer denoting the sum of all numbers in the given range satisfying the constraint.
 */

//endregion

//region Test cases

/**
 * Input: n = 7
 * Output: 21
 *
 * Input: n = 10
 * Output: 40
 */

//endregion

//region Solution

private fun main() {
    sumOfMultiples(n = 7)
    sumOfMultiples(n = 10)
}

private fun sumOfMultiples(n: Int): Int {
    val sum: Int = (1..n)
        .fold(0) { acc, it ->
            if (it % 3 == 0 || it % 5 == 0 || it % 7 == 0) {
                acc + it
            } else {
                acc
            }
        }

    println("Sum of multiples: $sum")
    return sum
}

//endregion