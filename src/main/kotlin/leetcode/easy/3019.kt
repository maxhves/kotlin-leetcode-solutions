package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed string 's' typed by a user. Changing the key is defined as using a key different
 * from the last used key. For example, 's = "ab"' has a change of key while 's = "bBBb" does not have any.
 *
 * Return the number of times the user had to change the key.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over the string 's'.
 * - Keep track of the previous char.
 * - Convert both chars to their lowercase counterpart.
 * - If the current char is different to the previous, add one to a result.
 * - Return the final resulting sum.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    countKeyChanges(s = "aAbBcC")

    // Output: 0
    countKeyChanges(s = "AaAaAaaA")
}

private fun countKeyChanges(s: String): Int {
    var keyChangeCount = 0

    for (i in 1..s.lastIndex) {
        val previousChar = s[i - 1].lowercaseChar()
        val currentChar = s[i].lowercaseChar()

        if (previousChar != currentChar) {
            keyChangeCount++
        }
    }

    return keyChangeCount
}

//endregion
