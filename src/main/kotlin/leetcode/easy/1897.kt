package leetcode.easy

//region Problem

/**
 * You are given an array of strings (words) that are 0-indexed.
 *
 * In one operation, pick two distinct indices (i) and (j), where (words[i]) is a non-empty string, and
 * movie any character from (words[i]) to any position (words[j]).
 *
 * Return (true) if you can make every string in (words) equal using any number of operations, and
 * (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Iterate over each char in each word of the (words) array.
 * - Place each character into a character frequency map.
 * - Iterate over the map and check if each char can be split exactly amongst the number of words we
 *   have in the (words) array.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    makeEqual(
        words = arrayOf("abc", "aabc", "bc"),
    )
}

private fun makeEqual(words: Array<String>): Boolean {
    val wordSplit = words.size
    val charFrequencies = HashMap<Char, Int>()

    for (word in words) {
        for (char in word) {
            charFrequencies[char] = charFrequencies.getOrDefault(char, 0) + 1
        }
    }

    for (value in charFrequencies.values) {
        if (value % wordSplit != 0) {
            return false
        }
    }

    return true
}

//endregion
