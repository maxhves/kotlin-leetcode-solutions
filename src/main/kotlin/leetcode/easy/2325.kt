package leetcode.easy

//region Problem

/**
 * You are given the strings `key` and `message`, which represent a cipher key and a secret message,
 * respectively. The steps to decode `message` are as follows:
 *  - Use the first appearance of all 26 lowercase English letters in `key` as the order of the
 *    substitution table.
 *  - Align the substitution table with the regular English alphabet.
 *  - Each letter in `message` is then substituted using the table.
 *  - Spaces `' '` are transformed to themselves.
 *
 *  For example, given `key = "happy boy"` (actual key would have been at least one instance of each letter
 *  in the alphabet), we have the partial substitution table of (`'h' -> 'a'`, `'a' -> 'b'`, `'p' -> 'c'`
 *  `'y' -> 'd'`, `'b' -> 'e'`, `'o' -> 'f'`).
 *
 *  Return the decoded message.
 */

//endregion

//region Test cases

/**
 * Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * Output: "this is a secret"
 *
 * Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * Output: "the five boxing wizards jump quickly
 */

//endregion

//region Solution

private fun main() {
    decodeMessage(key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv")
    decodeMessage(key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb")
}

private fun decodeMessage(key: String, message: String): String {
    val map = HashMap<Char, Char>()
    var currentChar = 'a'

    for (char in key) {
        if (char != ' ' && map[char] == null) {
            map[char] = currentChar

            if (currentChar == 'z') {
                currentChar = 'a'
            } else {
                currentChar++
            }
        }
    }

    var decodedMessage = ""
    for (char in message) {
        decodedMessage += if (char == ' ') ' ' else map[char]
    }

    return decodedMessage
}

//endregion