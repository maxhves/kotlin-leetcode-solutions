package leetcode.medium

//region Problem

/**
 * Given two strings (s1) and (s2), return (true) if (s2) contains a permutation of (s1), or (false)
 * otherwise.
 *
 * In other words, return (true) if one of (s1)'s permutations is the substring of (s2).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - Is there a substring of the exact same size?
 * - It has to also contain the exact same characters.
 * - We don't care about the order.
 * - We should use a sliding window.
 *
 * Steps:
 * 1. Initialize some variables:
 *    - (s1Frequencies): IntArray, character frequencies in (s1).
 *    - (s2Frequencies): IntArray, character frequencies in (s2).
 * 2. Build the frequency arrays, entirely for (s1) and for the first (n) characters in (s2).
 *    - The first (n) characters are the length of (s1) and is our first window.
 * 3. Iterate from 0 upTo remainder of indices after the first window:
 *    - Check if (s1Frequencies) is equal to (s2Frequencies).
 *      - If yes, immediately return true.
 *      - Otherwise, we continue on.
 *    - We need to remove the left most char from (s2Frequencies), this will make our window smaller
 *      on the left side.
 *    - We need to then extend our window to the right.
 *    - We make sure to keep a window of length (s1.length).
 * 4. Ultimately return whether (s1Frequencies) and (s2Frequencies) are equal.
 */

//endregion

//region Solution

private fun main() {
    // Output: false
    checkInclusion(s1 = "hello", s2 = "ooolleoooleh")

    // Output: true
    checkInclusion(s1 = "adc", s2 = "dcda")

    // Output: true
    checkInclusion(s1 = "ab", s2 = "eidbaooo")

    // Output: false
    checkInclusion(s1 = "ab", s2 = "eidboaoo")
}

private fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) {
        return false
    }

    val s1Frequencies = IntArray(26)
    val s2Frequencies = IntArray(26)

    for (i in s1.indices) {
        s1Frequencies[s1[i] - 'a']++
        s2Frequencies[s2[i] - 'a']++
    }

    for (i in 0 until s2.length - s1.length) {
        if (s1Frequencies.contentEquals(s2Frequencies)) {
            return true
        }

        s2Frequencies[s2[i] - 'a']--
        s2Frequencies[s2[i + s1.length] - 'a']++
    }

    return s1Frequencies.contentEquals(s2Frequencies)
}

//endregion
