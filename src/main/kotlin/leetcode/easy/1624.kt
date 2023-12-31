package leetcode.easy

//region Problem

/**
 * Given a string (s), return the length of the longest substring between two equal characters,
 * excluding the two characters. If there is no such substring, return (-1).
 *
 * A substring is a contiguous sequence of characters within a string.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialise a HashMap for keeping track of character start positions.
 * - Initialise an Int (maxBetweenSubstring) set to -1.
 * - Iterate over the string (s):
 *   - If the current character does not exist in the HashMap; insert it.
 *   - Else:
 *     - Check the difference between the start and end indexes.
 *     - Update (maxBetweenSubstring).
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    maxLengthBetweenEqualCharacters(s = "abca")
}

private fun maxLengthBetweenEqualCharacters(s: String): Int {
    val characterStartPositions = HashMap<Char, Int>(s.length)
    var maxBetweenSubstring = -1

    for (i in 0..s.lastIndex) {
        val char = s[i]

        if (char !in characterStartPositions) {
            characterStartPositions[char] = i
        } else {
            val startPosition = characterStartPositions.getOrDefault(char, 0)

            maxBetweenSubstring = maxOf(
                maxBetweenSubstring,
                i - startPosition - 1
            )
        }
    }

    return maxBetweenSubstring
}

//endregion
