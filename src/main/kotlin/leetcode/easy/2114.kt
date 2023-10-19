package leetcode.easy

//region Problem

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 * You are given an array of strings `sentences`, where each `sentence[i]` represents a single sentence.
 * Return the maximum number of words that appear in a single sentence.
 */

//endregion

//region Test cases

/**
 * Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
 * Output: 6
 *
 * Input: ["please wait", "continue to fight", "continue to win"]
 * Output: 3
 */

//endregion

//region Solution

private fun main() {
    mostWordsFoundRevised(sentences = arrayOf("alice and bob love leetcode", "i think so too", "this is great thanks very much"))
    mostWordsFoundRevised(sentences = arrayOf("please wait", "continue to fight", "continue to win"))
}

/**
 * Initial attempt
 */
private fun mostWordsFound(sentences: Array<String>): Int {
    val wordArrays = sentences.map { it.split(" ") }
    val maxOf = wordArrays.maxOf { it.size }

    println("The highest word count is: $maxOf")
    return maxOf
}

/**
 * Revised attempt
 */
private fun mostWordsFoundRevised(sentences: Array<String>): Int {
    val maxCount = sentences.maxOf { sentence -> sentence.count { it == ' ' } } + 1
    println("The highest word count is: $maxCount")
    return maxCount
}

//endregion