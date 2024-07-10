package leetcode.easy

import kotlin.math.abs

//region Problem

/**
 * You are given two strings 's' and 't' such that every character occurs at most once in 's' and 't' is
 * a permutation of 's'.
 *
 * The permutation difference between 's' and 't' is defined as the sum of the absolute difference between
 * the index of the occurrence of each character in 's' and the index of the occurrence of the same
 * character in 't'.
 *
 * Return the permutation difference between 's' and 't'.
 */

//endregion

//region Steps to solve

/**
 * We should compare the absolute difference between character occurrence indexes.
 * - Iterate over each string simultaneously.
 * - Store index of character in HashMap.
 * - If a character already exists in the HashMap, add the absolute difference of it's value to a result.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    findPermutationDifference(s = "abc", t = "bac")

    // Output: 12
    findPermutationDifference(s = "abcde", t = "edbac")
}

private fun findPermutationDifference(s: String, t: String): Int {
    var permutationDifference = 0
    val occurrenceMap = hashMapOf<Char, Int>()

    for (index in s.indices) {
        val sChar = s[index]
        val tChar = t[index]

        if (occurrenceMap.containsKey(sChar)) {
            permutationDifference += abs(occurrenceMap[sChar]!! - index)
        } else {
            occurrenceMap[sChar] = index
        }

        if (occurrenceMap.containsKey(tChar)) {
            permutationDifference += abs(occurrenceMap[tChar]!! - index)
        } else {
            occurrenceMap[tChar] = index
        }
    }

    return permutationDifference
}

//endregion
