package leetcode.easy

//region Problem

/**
 * Given a string (s) and a character (letter), return the percentage of characters in (s) that equal
 * (letter) rounded down to the nearest whole percent.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - To find the percentage we can take the number of occurrences and divide it by the total elements,
 *    we can then multiply this number by 100.
 *
 * 1. Iterate over the (s) array.
 * 2. For each (char) in (s):
 *     - If (char) is equal to (letter):
 *        - Increase the occurrence count.
 * 3. Return the occurrence count as a percentage of the length of s.
 */

//endregion

//region Solution

private fun main() {
    // Output: 33
    percentageLetter(s = "foobar", letter = 'o')

    // Output: 0
    percentageLetter(s = "jjjj", letter = 'k')
}

private fun percentageLetter(s: String, letter: Char): Int {
    var occurrences = 0

    for (char in s) {
        if (char == letter) {
            occurrences++
        }
    }

    return ((occurrences.toDouble() / s.length) * 100).toInt()
}

//endregion
