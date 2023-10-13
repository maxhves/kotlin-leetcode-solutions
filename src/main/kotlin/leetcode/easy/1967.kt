package leetcode.easy

//region Problem

/**
 * Given an array of strings `patterns` and a string `word`, return the number of strings in `patterns`
 * that exist as a substring in `word`.
 *
 * A substring is a contiguous sequence of characters within a string.
 */

//endregion

//region Steps to solve

/**
 * 1. Fold pattern array into count of contains() matches.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    numOfStrings(patterns = arrayOf("a", "abc", "bc", "d"), word = "abc")

    // Output: 2
    numOfStrings(patterns = arrayOf("a", "b", "c"), word = "aaaaabbbbb")

    // Output: 3
    numOfStrings(patterns = arrayOf("a", "a", "a"), word = "ab")
}

private fun numOfStrings(patterns: Array<String>, word: String): Int {
    return patterns.fold(0) { acc, s -> if (word.contains(s)) acc + 1 else acc }
}

//endregion