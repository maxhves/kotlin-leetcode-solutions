package leetcode.easy

//region Problem

/**
 * You are given a string `s` consisting of lowercase English letters, and you are allowed to perform
 * operations on it. In one operation, you can replace a character in `s` with another lowercase English
 * letter.
 *
 * Your task is to make `s` a palindrome with the minimum number of operations possible. If there are
 * multiple palindromes that can be made using the minimum number of operations, make the lexicographically
 * smallest one.
 *
 * A string `a` is lexicographically smaller than a string `b` (of the same length) if in the first position
 * where `a` and `b` differ, string `a` has a letter that appears earlier in the alphabet than the corresponding
 * letter in `b`.
 *
 * Return the resulting palindrome string.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the string.
 *    - Compare first and last characters:
 *      - If they are the same, move on.
 *      - If they are different:
 *        - Take the one that is lexicographically bigger.
 *        - Replace it.
 * 2. Return resulting string.
 */

//endregion

//region Solution

private fun main() {
    // Output: "efcfe"
    makeSmallestPalindrome(s = "egcfe")

    // Output: "abba"
    makeSmallestPalindrome(s = "abcd")
}

private fun makeSmallestPalindrome(s: String): String {
    val arraySize = s.length - 1
    val charArray = s.toCharArray()

    for (i in 0..arraySize) {
        val start = charArray[i]
        val end = charArray[arraySize - i]

        if (start > end) {
            charArray[i] = end
        } else {
            charArray[arraySize - i] = start
        }
    }

    return String(charArray)
}

//endregion