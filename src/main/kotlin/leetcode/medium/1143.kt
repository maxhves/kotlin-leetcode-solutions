package leetcode.medium

//region Problem

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there
 * is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters
 * (can be none) deleted without changing the relative order of the remaining characters.
 * - For example, "ace" is a subsequence of "abcde".
 *
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {

}

private fun longestCommonSubsequence(text1: String, text2: String): Int {
    val text1Size = text1.length
    val text2Size = text2.length

    val dp = Array(text1Size + 1) { IntArray(text2Size + 1) }

    for (i in 1..text1Size) {
        for (j in 1..text2Size) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    return dp[text1Size][text2Size]
}

//endregion
