package leetcode.easy

import kotlin.math.max

//region Problem

/**
 * You are given a binary string (s) that contains at least one ('1').
 *
 * You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary
 * number that can be created from this combination.
 *
 * Return a string representing the maximum odd binary number that can be created from the given combination.
 *
 * Note that the result string can have leading zeros.
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * 1. Initialize some variables:
 *    - (zeroCount): Int, count of zero in string.
 *    - (oneCount): Int, count of ones in string.
 *    - (result): String, the resulting string.
 * 2. Iterate over the string (s), and for each:
 *    - If it is a ('0'), increment (zeroCount).
 *    - If it is a ('1'), increment (oneCount).
 * 3. If (oneCount) is equal to 1, return "1".
 * 4. Iterate for while (zeroCount) and (oneCount) are not equal to 0:
 *    - If (oneCount) is greater than 1:
 *      - Add ('1')s to (result) until we have one remaining.
 *      - Decrement (oneCount) when adding.
 *    - If (zeroCount) is greater than 0:
 *      - Add ('0')s to (result) until we have no more left.
 *      - Decrement (zeroCount) when adding.
 *    - Add the final ('1') to (result).
 * 5. Return (result) string.
 */

//endregion

//region Solution

private fun main() {
    // Output "1001"
    maximumOddBinaryNumber(s = "0101")

    // Output "001"
    maximumOddBinaryNumber(s = "010")
}

private fun maximumOddBinaryNumber(s: String): String {
    var zeroCount = 0
    var oneCount = 0
    val result = StringBuilder()

    for (char in s) {
        if (char == '0') {
            zeroCount++
        } else {
            oneCount++
        }
    }

    while (oneCount > 0) {
        if (oneCount > 1) {
            result.append('1')
            oneCount--
        } else if (zeroCount > 0) {
            result.append('0')
            zeroCount--
        } else {
            result.append('1')
            oneCount--
        }
    }

    return result.toString()
}

//endregion
