package leetcode.easy

//region Problem

/**
 * Given a string `s`, reverse the order of characters in each word within a sentence while preserving
 * whitespaces and initial word order.
 */

//endregion

//region Test cases

/**
 * Input: s = "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteel tsetnoc"
 *
 * Input: s = "God Ding"
 * Output: "doG gniD"
 */

//endregion

//region Steps to solve

/**
 * 1. Split words into Array<String>.
 * 2. Reverse string.
 * 3. Join Array<String> to string.
 */

//endregion

//region Solution

private fun main() {
    reverseWords(s = "Let's take LeetCode contest")
    reverseWords(s = "God Ding")
}

private fun reverseWords(s: String): String {
    val wordArray = s.split(" ")
    return wordArray.joinToString(" ") { it.reversed() }
}

//endregion