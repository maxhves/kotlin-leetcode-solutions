package leetcode.easy

import kotlin.math.max

//region Problem

/**
 * Given a string (s) of zeros and ones, return the maximum score after splitting the string into two
 * non-empty substrings (i.e. left substring and right substring).
 *
 * The score after splitting a string is the number of zeros in the left substring plus the number
 * of ones in the right substring.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Create a prefix array for the number of ones there are in the string (s).
 * - We can do this by iterating over the string an accumulating up the sum of ones so far, and for
 *   each index we set the current index to the current number of ones we have.
 * - We should do this in reverse order.
 * - We then iterate over the string again and count up the number of zeros we have.
 * - For each index we sum the accumulated zeros up with the number of accumulated ones we have for
 *   the next index.
 * - We return the max sum we have been able to find.
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    maxScore(s = "00")
}

private fun maxScore(s: String): Int {
    val onesPrefix = IntArray(s.length)
    var maxScore = 0

    var previousDigit = 0
    for (i in s.lastIndex downTo 0) {
        val digit = s[i].digitToInt()

        val accumulated = previousDigit + digit
        onesPrefix[i] = accumulated
        previousDigit = accumulated
    }

    var accumulatedZeros = 0
    for (i in 0 until s.lastIndex) {
        val digit = s[i].digitToInt()
        if (digit == 0) {
            accumulatedZeros++
        }
        maxScore = max(maxScore, accumulatedZeros + onesPrefix[i + 1])
    }

    return maxScore
}

//endregion
