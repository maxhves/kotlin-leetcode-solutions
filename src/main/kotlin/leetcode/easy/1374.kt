package leetcode.easy

//region Problem

/**
 * Given an integer (n), return a string with (n) characters such that each character in such string
 * occurs an odd number of times.
 *
 * The returned string must contain only lowercase English letters. If there are multiple valid strings,
 * return any of them.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate from 0 up to and including (n):
 *    - If (n) is odd simply fill a string with a single char.
 *    - If (n) is even, fill a string with a char for (n - 1) and then fill with another char one time.
 * 2. Return the resulting string.
 */

//endregion

//region Solution

private fun main() {
    // Output: "pppz"
    generateTheString(n = 4)

    // Output: "xy"
    generateTheString(n = 2)
}

private fun generateTheString(n: Int): String {
    val charArray = CharArray(n)

    if (n % 2 == 0) {
        charArray.fill('a')
        charArray[n - 1] = 'b'
    } else {
        charArray.fill('a')
    }

    return String(charArray)
}

//endregion
