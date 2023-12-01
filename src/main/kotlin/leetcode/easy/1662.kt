package leetcode.easy

//region Problem

/**
 * Given two string arrays (word1) and (word2), return (true) if the two arrays represent the same string
 * and (false) otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Flat map the two input arrays.
 * - Check the size of the resulting array.
 *   - If they are equal continue.
 *   - If they are not equal, return false.
 * - Iterate over the two flat arrays:
 *   - Compare each character and return true if they are equal.
 *   - Return false as soon as one character is incorrect.
 */

//endregion

//region Solution

private fun main() {
    // Output true
    arrayStringsAreEqual(
        word1 = arrayOf("ab", "c"),
        word2 = arrayOf("a", "bc"),
    )
}

private fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    val word1String = word1.fold("") { a, s -> a + s }
    val word2String = word2.fold("") { a, s -> a + s }

    if (word1String.length != word2String.length) {
        return false
    }

    for (i in 0 .. word1String.lastIndex) {
        if (word1String[i] != word2String[i]) {
            return false
        }
    }

    return true
}

//endregion
