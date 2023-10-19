package leetcode.easy

//region Problem

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each
 * of the words consist of only uppercase and lowercase English letters (no punctuation).
 *  - For example, "Hello, World", "HELLO", and "hello world hello world" are all sentences.
 *
 *  You are given a sentence `s` and an integer `k`. You want to truncate `s` such that it only contains the first
 *  `k` words. Return `s` after truncating it.
 */

//endregion

//region Test cases

/**
 * Input: s = "Hello how are you Contestant", k = 4
 * Output: "Hello how are you"
 *
 * Input: s = "What is the solution to this problem", k = 4
 * Output: "What is the solution"
 */

//endregion

//region Solution

private fun main() {
    truncateSentence(s = "Hello how are you Contestant", k = 4)
    truncateSentence(s = "What is the solution to this problem", k = 4)
}

private fun truncateSentence(s: String, k: Int): String {
    var result = ""
    var counter = 0

    for (char in s) {
        if (char == ' ') {
            counter ++
        }

        if (counter == k) {
            break
        }

        result += char
    }

    return result
}

//endregion