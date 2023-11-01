package leetcode.easy

//region Problem

/**
 * A string is good if there are no repeated characters.
 *
 * Given a string (s), return the number of good substrings of length three in (s).
 *
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 *
 * A substring is a contiguous sequence of characters in a string.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Substrings must be of length three, therefore;
 *     - We can only take elements starting from 0 - (lastIndex - 3).
 *  - We need to be able to check if a string is distinct.
 *
 * 1. Iterate over the string (s); from 0 upTo s.lastIndex - 3.
 * 3. For each index (i);
 *     - We need to build our substring; we can use simply indexing.
 *     - [i] [i + 1] [i + 2].
 *     - Compare the indexes, if they are unique, increase the match count.
 * 4. Ultimately return the match count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    countGoodSubstrings(s = "xyzzaz")

    // Output: 4
    countGoodSubstrings(s = "aababcabc")
}

private fun countGoodSubstrings(s: String): Int {
    if (s.length < 3) {
        return 0
    }

    var goodSubstrings = 0

    for (i in 0 .. s.lastIndex - 2) {
        val charOne = s[i]
        val charTwo = s[i + 1]
        val charThree = s[i + 2]

        if (charOne != charTwo && charOne != charThree && charTwo != charThree) {
            goodSubstrings++
        }
    }

    return goodSubstrings
}

//endregion
