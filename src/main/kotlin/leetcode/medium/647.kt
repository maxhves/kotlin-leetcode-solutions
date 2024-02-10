package leetcode.medium

//region Problem

/**
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Basic idea is that we can check each index and think of it as the middle of a substring.
 * - We can keep checking all strings where the current index is the middle item, and subsequently check
 *   whether this string is palindromic.
 * - We need to check for both odd and even palindromes.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    countSubstrings(s = "abc")

    // Output: 6
    countSubstrings(s = "aaa")
}

private fun countSubstrings(s: String): Int {
    var totalPalindromes = 0

    // Palindrome checking
    fun countPalindromes(initialLeft: Int, initialRight: Int) {
        var left = initialLeft
        var right = initialRight

        while (left >= 0 && right <= s.lastIndex) {
            if (s[left] == s[right]) {
                totalPalindromes++
                left--
                right++
            } else {
                break
            }
        }
    }

    // Check odd and even
    for (i in s.indices) {
        countPalindromes(i, i)
        countPalindromes(i, i + 1)
    }

    return totalPalindromes
}

//endregion
