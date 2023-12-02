package leetcode.easy

//region Problem

/**
 * You ae given an array of strings (words) and a string (chars).
 *
 * A string is good if it can be formed by characters from chars, each character can only be used once.
 *
 * Return the sum of lengths of all good strings in words.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Frequency count the characters in (chars).
 * - Iterate over (words) and for each (word):
 *   - Check if it can be formed using the chars from (chars).
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    countCharacters(
        words = arrayOf(
            "cat", "bt", "hat", "tree",
        ),
        chars = "atach",
    )
}

private fun countCharacters(words: Array<String>, chars: String): Int {
    val charFrequencies = IntArray(26)

    chars.forEach { char ->
        val charAsIndex: Int = char.code - 'a'.code
        charFrequencies[charAsIndex]++
    }

    fun wordIsGood(word: String): Boolean {
        val tempFrequencies = charFrequencies.copyOf()
        for (char in word) {
            val charAsIndex = char.code - 'a'.code
            if (--tempFrequencies[charAsIndex] < 0) {
                return false
            }
        }
        return true
    }

    return words.sumOf { word -> if (wordIsGood(word)) word.length else 0 }
}

//endregion
