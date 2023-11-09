package leetcode.medium

//region Problem

/**
 * Given a string (s), return the number of homogenous substrings of (s). Since the answer may be too
 * large, return it in modulo (10^9 + 7).
 *
 * A string is homogenous if all the characters of the string are the same.
 *
 * A substring is a contiguous sequence of characters within a string.
 */

//endregion

//region Steps to solve

// "aaaaaaa" of length N contains N * (N + 1) / 2 homogenous substrings (sum of the arithmetic progression).

/**
 * Considerations:
 *  - We need to split the string down into sets of repeated character strings.
 *  - This should give us our initial substrings.
 *  - To find the sum of the arithmetic progression we can use the following equation:
 *     - (n): Length of string, (n * (n + 1) / 2).
 *
 * Steps:
 * 1. Initialize some variables:
 *     - (tempSubstring): String, to hold our current substring.
 *     - (homogenousSubstringCount): Int, the count of homogenous substrings we find.
 * 2. Iterate over the string (s); for each (char):
 *     - If the previous character is equal to (char):
 *        - We continue searching.
 *        - Add this char to (tempSubstring).
 *     - If the previous character is not equal to (char):
 *        - Calculate the arithmetic progression.
 *        - Add the count to (homogenousSubstringCount).
 *        - Clear (tempSubstring).
 *        - Add this char to (tempSubstring).
 */

//endregion

//region Solution

private fun main() {
    // Output: 13
    countHomogenous(s = "abbcccaa")
}

private fun countHomogenous(s: String): Int {
    val modulo = 1_000_000_007
    var homogenousSubstringCount = 0L
    var currentRun = 1L

    for (i in 1 .. s.lastIndex) {
        val char = s[i]
        val previousChar = s[i - 1]

        if (previousChar == char) {
            currentRun++
        } else {
            homogenousSubstringCount += (currentRun * (currentRun + 1) / 2) % modulo
            currentRun = 1
        }
    }

    homogenousSubstringCount += (currentRun * (currentRun + 1) / 2) % modulo

    return homogenousSubstringCount.toInt()
}

//endregion
