package leetcode.easy

import java.math.BigInteger

//region Problem

/**
 * You are given a large integer represented as an integer array (digits), where each (digits[i]) is the
 * (ith) digit of the integer. the digits are ordered from most significant to the least significant in
 * left-to-right order. The large integer does not contain any leading (0)'s.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Map (digits) into an integer.
 * - Plus one.
 * - Return as an integer array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [2, 0, 0, 0, 0, 0, 0]
    plusOne(digits = intArrayOf(1, 9, 9, 9, 9, 9))

    // Output: [1, 2, 4]
    plusOne(digits = intArrayOf(1, 2, 4))
}

private fun plusOne(digits: IntArray): IntArray {
    for (i in digits.lastIndex downTo 0) {
        if (digits[i] + 1 == 10) {
            digits[i] = 0
        } else {
            digits[i]++
            return digits
        }
    }

    val result = IntArray(digits.size + 1) { index ->
        if (index == 0) 1 else 0
    }

    return result
}

//endregion
