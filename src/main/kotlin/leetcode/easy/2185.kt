package leetcode.easy

//region Problem

/**
 * You are given an array of strings (words) and a string (pref).
 *
 * Return the number of strings in (words) that contain (pref) as a prefix.
 *
 * A prefix of a string (s) is any leading contiguous substring of (s).
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the (words) array.
 * 2. Using a regular expression:
 *    - Compare if (word) matches the regular expression pattern.
 * 3. If we have a match, increase the answer count.
 * 4. Return the eventual result.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    prefixCount(
        words = arrayOf(
            "pay",
            "attention",
            "practice",
            "attend",
        ),
        pref = "at",
    )

    // Output: 0
    prefixCount(
        words = arrayOf(
            "leetcode",
            "win",
            "loops",
            "success",
        ),
        pref = "code",
    )
}

private fun prefixCount(words: Array<String>, pref: String): Int {
    val regex = Regex("^$pref.*$")
    var matchCount = 0

    for (word in words) {
        if (regex.matches(word)) {
            matchCount++
        }
    }

    return matchCount
}

//endregion
