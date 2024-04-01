package leetcode.easy

//region Problem

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-whitespace characters only.
 */

//endregion

//region Steps to solve

/**
 * Steps:
 * - Split the string based on spaces.
 * - Take the last item in the array of split words.
 * - Return the length of this item.
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    lengthOfLastWord(s = "Hello World")
}

private fun lengthOfLastWord(s: String): Int {
    val wordSplits = s.trim().split(" ")
    return wordSplits.last().length
}

//endregion
