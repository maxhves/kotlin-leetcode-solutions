package leetcode.medium

import kotlin.math.abs

//region Problem

/**
 * You are given two strings of the same length (s) and (t). In one step you can choose any character of
 * (t) and replace it with another character.
 *
 * Return the minimum number of steps to make (t) an anagram of (s).
 *
 * An anagram of a string is a string that contains the same characters wth a different (or the same)
 * ordering.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We should count the frequencies for each char in the input strings.
 * - We can then compare each char, counting how many differences there are.
 * - We can return the number of differences.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    minSteps(s = "bab", "aba")

    // Output: 5
    minSteps(s = "leetcode", t = "practice")

    // Output: 0
    minSteps(s = "anagram", t = "mangaar")
}

private fun minSteps(s: String, t: String): Int {
    val sFrequencies = IntArray(26)
    val tFrequencies = IntArray(26)
    var numberOfDifferences = 0

    for (i in s.indices) {
        sFrequencies[s[i] - 'a']++
        tFrequencies[t[i] - 'a']++
    }

    for (i in sFrequencies.indices) {
        val sFrequency = sFrequencies[i]
        val tFrequency = tFrequencies[i]

        numberOfDifferences+= abs(sFrequency - tFrequency)
    }

    return numberOfDifferences / 2
}

//endregion
