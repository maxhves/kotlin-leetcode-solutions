package leetcode.medium

//region Problem

/**
 * An integer (n) is strictly palindromic if, for every base (b) between (2) and (n - 2) inclusive, the
 * string representation of the integer (n) in base (b) is palindromic.
 *
 * Given an integer (n), return (true) if (n) is strictly palindromic and (false) otherwise.
 *
 * A string is palindromic if it reads the same forward and backward.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate from 2 to (n - 2).
 * 2. For each (i) find the base-(i):
 *    - Keep dividing (n) by (i), keeping the remainders.
 *    - Check if this base is palindromic.
 *    - Return false immediately if the condition is not palindromic.
 * 3. If we reach this far, return true.
 */

//endregion

//region Solution

private fun main() {
    // Output: false
    isStrictlyPalindromic(n = 9)

    // Output: false
    isStrictlyPalindromic(n = 4)
}

private fun isStrictlyPalindromic(n: Int): Boolean {
    for (base in 2 until n) {
        val digits = mutableListOf<Int>()
        var currentNum = n

        while (currentNum > 0) {
            digits.add(currentNum % base)
            currentNum /= base
        }

        if (digits != digits.reversed()) {
            return false
        }
    }
    return true
}

//endregion
