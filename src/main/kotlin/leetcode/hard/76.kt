package leetcode.hard

//region Problem

/**
 * Given two strings (s) and (t) of lengths (m) and (n) respectively, return the minimum window substring
 * of (s) such that every character in (t) including duplicates, is included in the window. If there is no
 * such substring, return the empty string ("").
 *
 * The testcases will be generated such that the answer is unique.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - Find a substring of (s) that contains all the letters of (t).
 * - Find the minimum substring.
 *
 * Steps:
 * - Keep a HashMap to store the frequency of the letters in (t).
 * - Keep a HashMap to store the frequency of our current window.
 * - Track how many letter matches we (need), that being how many chars are we required to have:
 *   - At least two of ('a') for example.
 * - Track how many matches that we currently (have).
 * - Iterate over the (s) string:
 *   - Keep adding items to our window HashMap until the number of (have) is equal to the number of (need).
 *     - (have) can be increased when the letter in our window is EQUAL to the letter in the (t) frequency
 *       HashMap.
 *   - Check if (have) is now equal to (need).
 *     - If they are equal; we now have a successful window.
 *     - Set a result to the pair of startWindowIndex, endWindowIndex.
 *       - Only make this set if the new window is smaller.
 *     - Keep removing items from the window until our window is no longer valid.
 *     - This means we also must increase our left pointer.
 *     - With each iteration, we must also check if this is a possible smaller substring result.
 */

//endregion

//region Solution

private fun main() {
    // Output: "BANC"
    minWindow(s = "ADOBECODEBANC", t = "ABC")
}

private fun minWindow(s: String, t: String): String {
    if (t.isEmpty()) {
        return ""
    }

    val tFrequencies = HashMap<Char, Int>()
    val windowFrequencies = HashMap<Char, Int>()

    for (char in t) {
        tFrequencies[char] = tFrequencies.getOrDefault(char, 0) + 1
    }

    val neededMatches = tFrequencies.size
    var haveMatches = 0
    var left = 0
    var result = -1 to -1
    var resultLength = Int.MAX_VALUE

    for (right in 0 .. s.lastIndex) {
        val rightChar = s[right]

        windowFrequencies[rightChar] = windowFrequencies.getOrDefault(rightChar, 0) + 1

        if (rightChar in tFrequencies && windowFrequencies[rightChar] == tFrequencies[rightChar]) {
            haveMatches++
        }

        while (haveMatches == neededMatches) {
            if ((right - left + 1) < resultLength) {
                result = left to right
                resultLength = right - left + 1
            }

            windowFrequencies[s[left]] = windowFrequencies[s[left]]!! - 1

            if (s[left] in tFrequencies && windowFrequencies[s[left]]!! < tFrequencies[s[left]]!!) {
                haveMatches--
            }

            left++
        }
    }

    return if (resultLength == Int.MAX_VALUE) {
        ""
    } else {
        s.substring(result.first .. result.second)
    }
}

//endregion
