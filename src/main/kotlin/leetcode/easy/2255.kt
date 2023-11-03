package leetcode.easy

//region Problem

/**
 * You are given a string array (words) and a string (s), where (words[i]) and (s) comprise only of
 * lowercase English letters.
 *
 * Return the number of strings in (words) that are a prefix of (s).
 *
 * A prefix of a string is a substring that occurs at the beginning of the string. A substring is a
 * contiguous sequence of characters within a string.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to know if (word) is a prefix of (s).
 *  - Meaning; does (s) begin with (word)?
 *
 * 1. Initialize a set to track prefix instances.
 * 2. Iterate over (s) and for each index:
 *     - Add the accumulated prefix to our set.
 * 3. Iterate over the (words) array.
 * 4. For each (word);
 *     - Check if the (word) exists in our set.
 *     - If the (word) exists, it is a prefix, increase our match count.
 * 5. Return the total match count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    countPrefixes(words = arrayOf("a", "b", "c", "ab", "bc", "abc"), s = "abc")

    // Output: 2
    countPrefixes(words = arrayOf("a", "a"), s = "aa")
}

private fun countPrefixes(words: Array<String>, s: String): Int {
    val possiblePrefixes = HashSet<String>()
    var prefixMatchCount = 0

    var accumulatedPrefix = ""
    for (char in s) {
        accumulatedPrefix += char
        possiblePrefixes.add(accumulatedPrefix)
    }

    for (word in words) {
        if (possiblePrefixes.contains(word)) {
            prefixMatchCount++
        }
    }

    return prefixMatchCount
}

//endregion
