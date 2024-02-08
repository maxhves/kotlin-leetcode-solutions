package leetcode.medium

//region Problem

/**
 * Given an integer n, return the least number of perfect square numbers that to n.
 *
 * A perfect square is an integer that is the square of an integer, in other words, it is the product
 * of some integer with itself. For example, 1, 4, 9 and 16 are perfect squares while 3 and 11 are not.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    numSquares(n = 12)

    // Output: 2
    numSquares(n = 13)
}

private fun numSquares(n: Int): Int {
    val dp = Array(n + 1) { n }
    dp[0] = 0

    for (i in 1..n) {
        for (s in 1..i) {
            val square = s * s

            if (square > i) {
                break
            }

            dp[i] = minOf(dp[i], 1 + dp[i - square])
        }
    }

    return dp[n]
}

//endregion
