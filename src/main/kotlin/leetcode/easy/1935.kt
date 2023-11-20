package leetcode.easy

//region Problem

/**
 * There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard
 * work properly.
 *
 * Given a string (text) of words separated by a single space (no leading or trailing spaces) and a string
 * (brokenLetters) of all distinct letter keys that are broken, return the number of words in (text)
 * you can fully type using this keyboard.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize a HashSet (brokenChars).
 * - Initialize an Int (possibleCompleteWords), set to 0.
 * - Iterate over the characters in (brokenLetters):
 *   - Add each char to the (brokenChars) hash set.
 * - Initialize a String (currentWord), set to "".
 * - Initialize a boolean (currentWordIsPossible) set to true.
 * - Iterate over the (text) string, and for each (char)
 *   - If (char) is equal to a blank space (" ").
 *     - We should have a complete word.
 *     - If (currentWordIsPossible) is equal to true:
 *       - Increase (possibleCompleteWords) by 1.
 *     - Else; set (currentWordIsPossible) to true.
 *   - If (currentWordIsPossible):
 *      - If (char) is in (brokenChars) set (currentWordIsPossible) to false.
 * - Return (possibleCompleteWords).
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    canBeTypedWords(text = "hello world", brokenLetters = "ad")
}

private fun canBeTypedWords(text: String, brokenLetters: String): Int {
    val brokenChars = HashSet<Char>(brokenLetters.length)

    for (char in brokenLetters) {
        brokenChars.add(char)
    }

    var possibleCompleteWords = 0
    var currentWordIsPossible = true

    for (char in text) {
        if (char == ' ') {
            if (currentWordIsPossible) {
                possibleCompleteWords++
            }
            currentWordIsPossible = true
        } else {
            if (currentWordIsPossible) {
                if (char in brokenChars) {
                    currentWordIsPossible = false
                }
            }
        }
    }

    if (currentWordIsPossible) {
        possibleCompleteWords++
    }

    return possibleCompleteWords
}

//endregion
