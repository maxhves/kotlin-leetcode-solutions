package leetcode.easy

//region Problem

/**
 * Given two positive integers (a) and (b), return the number of common factors of (a) and (b).
 *
 * An integer (x) is a common factor of (a) and (b) if (x) divides both (a) and (b).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We can only iterate through numbers that are up to the smallest of (a) and (b).
 *  - We should iterate from 1 upTo (minOf(a, b)).
 *  - Check if each number is divisible into both, if so; increase a count.
 *  - Return this count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    commonFactors(a = 12, b = 6)

    // Output: 2
    commonFactors(a = 25, b = 30)
}

private fun commonFactors(a: Int, b: Int): Int {
    var commonFactorCount = 0

    for (i in 1 .. minOf(a, b)) {
        if (a % i == 0 && b % i == 0) {
            commonFactorCount++
        }
    }

    return commonFactorCount
}

//endregion
