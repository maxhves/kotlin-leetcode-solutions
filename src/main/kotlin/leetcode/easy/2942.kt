package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed array of strings (words) and a character (x).
 *
 * Return an array of indices representing the words that contain the character (x).
 *
 * Note that the returned array may be in any order.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a List<Int> (result), for containing the result indices.
 * - Iterate over the strings in (words) and for each (word):
 *   - Iterate over the characters in (word) and for each (char):
 *     - Check if (char) is equal to (x);
 *       - If it is equal, add (char) to (result) and then break.
 * - Ultimately return (result).
 */

//endregion

//region Solution

private fun main() {
    // Output: [0, 1]
    findWordsContaining(
        words = arrayOf("leet", "code"),
        x = 'e',
    )
}

private fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
    val result = mutableListOf<Int>()

    for (word in 0 .. words.lastIndex) {
        for (char in 0 .. words[word].lastIndex) {
            if (words[word][char] == x) {
                result.add(word)
                break
            }
        }
    }

    return result
}

//endregion
