package leetcode.easy

//region Problem

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting wth word1. If a string is longer than the other, append the additional letters onto the end of
 * the merged string.
 *
 * Return the merged string.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over word1 and for each index:
 *    - Take char from word1, append to result.
 *    - Take char from word2, append to result.
 *    - if (i) is greater than the last index of word1 but smaller than the last index of word2:
 *      - Append everything from i to last index of word2.
 * 2. Return the resulting string.
 */

//endregion

//region Solution

private fun main() {
    // Output: "apbqcr"
    mergeAlternately(word1 = "abc", word2 = "pqr")

    // Output: "apbqrs"
    mergeAlternately(word1 = "ab", word2 = "pqrs")

    // Output: "apbqcd"
    mergeAlternately(word1 = "abcd", word2 = "pq")
}

private fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()
    val minLength = minOf(word1.length, word2.length)

    for (i in 0 until minLength) {
        result.append(word1[i])
        result.append(word2[i])
    }

    result.append(word1.substring(minLength))
    result.append(word2.substring(minLength))

    return result.toString()
}

//endregion