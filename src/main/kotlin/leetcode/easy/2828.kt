package leetcode.easy

//region Problem

/**
 * Given an array of strings (words) and a string (s), determine if (s) is an acronym of words.
 *
 * The string (s) is considered an acronym of (words) if it can be formed by concatenating the first character
 * of each string in (words) in order. For example, ("ab") can be formed from (["apple"], ["banana"]), but
 * it can't be formed from (["bear"], ["aardvark"]).
 *
 * Return (true) if (s) is an acronym of (words), and (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the (words) array.
 * 2. For each (word):
 *     - Check if first index of (word) matches the (i) index of (s).
 *     - If they match; continue.
 *     - If they don't match; immediately return false.
 * 3. Ultimately return true.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isAcronym(words = listOf("alice", "bob", "charlie"), s = "abc")
}

private fun isAcronym(words: List<String>, s: String): Boolean {
    if (s.length != words.size) {
        return false
    }

    for (i in words.indices) {
        if (words[i].isEmpty()) {
            return false
        } else {
            if (words[i][0] != s[i]) {
                return false
            }
        }
    }

    return true
}

//endregion
