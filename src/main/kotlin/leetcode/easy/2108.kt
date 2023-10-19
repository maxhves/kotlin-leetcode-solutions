package leetcode.easy

//region Problem

/**
 * Given an array of strings (words), return the first palindromic string in the array. If there is no
 * such string, return an empty string ("").
 *
 * A string is palindromic if it reads the same forward and backward.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array of strings.
 * 2. Check if the current string (i) is the same as the reversed string (i):
 *    - If yes, return (i).
 *    - If no, continue the loop.
 * 3. Ultimately return an empty string if we reach this far.
 */

//endregion

//region Solution

private fun main() {
    // Output: "ada"
    firstPalindrome(words = arrayOf("abc", "car", "ada", "racecar", "cool"))

    // Output: "racecar"
    firstPalindrome(words = arrayOf("notapalindrome", "racecar"))

    // Output: ""
    firstPalindrome(words = arrayOf("def", "ghi"))
}

private fun firstPalindrome(words: Array<String>): String {
    for (word in words) {
        if (word == word.reversed()) {
            return word
        }
    }
    return ""
}

//endregion