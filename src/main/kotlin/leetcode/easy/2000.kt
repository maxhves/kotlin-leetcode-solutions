package leetcode.easy

//region Problem

/**
 * Given a 0-indexed string `word` and a character `ch`, reverse the segment of `word` that starts at
 * index `0` and ends at the index of the first occurrence of `ch` (inclusive). If the character `ch`
 * does not exist in `word`, do nothing.
 *
 * Return the resulting string.
 */

//endregion

//region Steps to solve

/**
 * 1. Find indexOf `ch`.
 * 2. If not found, return `word`.
 * 3. If found, return reversed substring of left + substring of right.
 */

//endregion

//region Solution

private fun main() {
    // Output: "dcbaefd"
    reversePrefix(word = "abcdefd", ch = 'd')

    // Output: "zxyxxe"
    reversePrefix(word = "xyxzxe", ch = 'z')
}

private fun reversePrefix(word: String, ch: Char): String {
    val indexOfCh = word.indexOf(ch)
    return if (indexOfCh == -1) {
        word
    } else {
        val prefix = word.substring(0, indexOfCh + 1)
        val suffix = word.substring(indexOfCh + 1, word.length)
        prefix.reversed() + suffix
    }
}

//endregion