package leetcode.easy

//region Problem

/**
 * You are given a string "s" formed by digits and '#'. We want to map "s" to English lowercase
 * characters as follows:
 *  - Characters ('a'  to 'i') are represented by ('1' to '9') respectively.
 *  - Characters ('j' to 'z') are represented by ("10#" to "26#") respectively.
 *
 * Return the string formed after mapping.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the chars of "s".
 * 2. If the char is equal to '#':
 *    - We know that the previous 2 digits should be exchanged for a char.
 *    - This also means that we must remove the previous 2 chars added to the array.
 * 3. Otherwise, exchange the digit for a letter char value:
 *    - Take the digit as a char and plus 'a'.code to give us its letter.
 */

//endregion

//region Solution

private fun main() {
    // Output: "jkab"
    freqAlphabets(s = "10#11#12")

    // Output: "acz"
    freqAlphabets(s = "1326#")
}

private fun freqAlphabets(s: String): String {
    val result = StringBuilder()

    var i = 0
    while (i < s.length) {
        if (i + 2 < s.length && s[i + 2] == '#') {
            result.append('a' + "${s[i]}${s[i + 1]}".toInt() - 1)
            i += 3
        } else {
            result.append('a' + s[i].digitToInt() - 1)
            i++
        }
    }

    return result.toString()
}

//endregion