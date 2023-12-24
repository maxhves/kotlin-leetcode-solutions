package leetcode.easy

import kotlin.math.min

//region Problem

/**
 * You are given a string (s) consisting of only the characters ('0') and ('1'). In one operation,
 * you can change any ('0') to ('1') or vice versa.
 *
 * The string is called alternating if no two adjacent characters are equal. For example, the string
 * ("010") is alternating, while the string ("0100") is not.
 *
 * Return the minimum number of operations needed to make (s) alternating.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We know that either the string should start with a 0 or a 1, and subsequently each digit
 *   thereafter will alternate.
 * - Initialize two variables:
 *   - (evenStart), set to 0.
 *   - (oddStart), set to 0.
 * - Iterate over the string (s), and for each:
 *   - If the index is even:
 *     - If the digit is also even, increment (oddStart).
 *     - Otherwise increment (evenStart).
 *   - If the index is odd:
 *     - If the digit is also odd, increment (oddStart)
 *     - Otherwise increment (evenStart).
 * - Return the minimum value of (oddStart) and (evenStart).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    minOperations(s = "10010100")

    // Output: 1
    minOperations(s = "0100")

    // Output: 0
    minOperations(s = "10")

    // Output: 2
    minOperations(s = "1111")
}

private fun minOperations(s: String): Int {
    var evenStartOperations = 0
    var oddStartOperations = 0

    for (i in 0..s.lastIndex) {
        val digit = s[i].digitToInt()

        if (i % 2 == 0) {
            if (digit == 0) {
                oddStartOperations++
            } else {
                evenStartOperations++
            }
        } else {
            if (digit == 1) {
                oddStartOperations++
            } else {
                evenStartOperations++
            }
        }
    }

    return min(evenStartOperations, oddStartOperations)
}

//endregion
