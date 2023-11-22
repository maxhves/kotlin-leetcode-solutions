package leetcode.easy

import java.util.HashMap

//region Problem

/**
 * A distinct string is a string that is present only once in an array.
 *
 * Given an array of strings (arr) and an integer (k), return the (kth) distinct string
 * present in (arr). If there are fewer than (k) distinct strings, return an empty string ("").
 *
 * Note that the strings are considered inthe order in which they appear in the array.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: "a"
    kthDistinct(arr = arrayOf("d", "b", "c", "b", "c", "a"), k = 2)
}

private fun kthDistinct(arr: Array<String>, k: Int): String {
    val occurrences = HashMap<String, Int>(arr.size)

    for (string in arr) {
        occurrences[string] = occurrences.getOrDefault(string, 0) + 1
    }

    var count = 0
    for (string in arr) {
        if ((occurrences[string] ?: 0) == 1) {
            count++
        }

        if (count == k) {
            return string
        }
    }

    return ""
}

//endregion
