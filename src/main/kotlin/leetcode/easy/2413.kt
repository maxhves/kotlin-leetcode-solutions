package leetcode.easy

import kotlin.time.times

//region Problem

/**
 * Given a positive integer `n`, return the smallest positive integer that is a multiple of
 * both 2 and `n`.
 */

//endregion

//region Test cases

/**
 * Input: n = 5
 * Output: 10
 *
 * Input: n = 6
 * Output: 6
 */

//endregion

//region Solution

private fun main() {
    smallestEvenMultiple(n = 5)
    smallestEvenMultiple(n = 6)
}

private fun smallestEvenMultiple(n: Int): Int {
    if (n % 2 == 0) {
        println("Smallest even multiple is: $n")
        return n
    } else {
        var currentMultiple = 1

        for (i in 1 until Int.MAX_VALUE) {
            if (currentMultiple * n % 2 == 0) {
                break
            } else {
                currentMultiple++
            }
        }

        println("Smallest even multiple is: ${currentMultiple * n}")
        return currentMultiple * n
    }
}

/**
 * Alternate short solution.
 */
private fun smallestEventMultipleAlternative(n: Int): Int {
    return if (n % 2 == 0) n else n * 2
}

//endregion