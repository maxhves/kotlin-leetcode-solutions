package leetcode.easy

//region Problem

/**
 * Reversing an integer means to reverse all its digits.
 *  - For example, reversing (2021) gives (1202). Reversing (12300) gives (321) as the leading zeroes
 *    are not retained.
 *
 * Given an integer (num), reverse (num) to get (reversed1) then reverse (reversed1) to get (reversed2).
 * Return (true) if (reversed2) equals (num).
 *
 * Otherwise, return false.
 */

//endregion

//region Steps to solve

/**
 * 1. Check if nums ends in '0'
 * 2. If yes, return true else false.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isSameAfterReversals(num = 526)

    // Output: false
    isSameAfterReversals(num = 1800)

    // Output: true
    isSameAfterReversals(num = 0)
}

private fun isSameAfterReversals(num: Int): Boolean {
    return if (num <= 9) true else num % 10 != 0
}

//endregion