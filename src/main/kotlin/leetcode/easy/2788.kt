package leetcode.easy

//region Problem

/**
 * Given an array of strings (words) and a character (separator), split each string in (words) by
 * (separator).
 *
 * Return an array of strings containing the new strings formed after the splits, excluding empty strings.
 *
 * Notes
 *  - (separator) is used to determine where the split should occur, but it is not included as part of the
 *    resulting strings.
 *  - A split may result in more than two strings.
 *  - The resulting strings must maintain the same order as they were initially given.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We have a list of strings, each element could contain many words.
 *  - The words are concatenated by a given separator.
 *
 * 1. Initialize a mutable list of strings.
 * 2. Iterate over the (words) list.
 * 3. For each word:
 *     - Initialize a new loop over the characters in (word).
 *     - Create a temporary string to hold each word.
 *     - For each character in word:
 *        - If the character is equal to (separator):
 *           - If our temporary string is not empty:
 *              - Add the temporary string to our result list.
 *        - If the character is not equal to (separator):
 *           - Append the character to the temporary string.
 * 4. Ultimately, return the resulting list.
 */

//endregion

//region Solution

private fun main() {
    // Output: ["one","two","three","four","five","six"]
    splitWordsBySeparator(words = listOf("one.two.three", "four.five", "six"), separator = '.')

    // Output: ["easy","problem"]
    splitWordsBySeparator(words = listOf("\$easy\$", "\$problem\$"), separator = '$')
}

private fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
    val flattenedWords = mutableListOf<String>()

    for (word in words) {
        var currentWord = ""

        for (char in word) {
            if (char == separator) {
                if (currentWord.isNotEmpty()) {
                    flattenedWords.add(currentWord)
                    currentWord = ""
                }
            } else {
                currentWord += char
            }
        }

        if (currentWord.isNotEmpty()) {
            flattenedWords.add(currentWord)
        }
    }

    return flattenedWords
}

//endregion
