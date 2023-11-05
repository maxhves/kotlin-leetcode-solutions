package leetcode.easy

//region Problem

/**
 * The letter value of a letter is its position in the alphabet starting from 0 (i.e. ('a' -> 0) etc.).
 *
 * The numerical value of some string of lowercase English letters (s) is the concatenation of the letter
 * values of each letter in (s), which is then converted into an integer.
 *  - For example, if (s = "acb"), we concatenate each letter's letter value, resulting in ("021"). After
 *    converting it, we get (21).
 *
 * You are given three strings (firstWord), (secondWord) and (targetWord), each consisting of lowercase
 * English letters ('a') through ('j') inclusive.
 *
 * Return (true) if the summation of the numerical values of (firstWord) and (secondWord) equals the
 * numerical value of (targetWord), or (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Each word (first/second/target) needs to be converted into a numerical format.
 *  - (first) and (second) are then summed and checked for equality to (target).
 *
 * 1. Initialize some variables:
 *     - (firstSum): Int at 0.
 *     - (secondSum): Int at 0.
 *     - (targetSum): Int at 0.
 *     - (targetDigits): String at empty.
 *     - (firstDigits): String at empty.
 *     - (secondDigits): String at empty.
 * 2. Iterate over the (targetWord); and for each (char):
 *     - Convert the (char) into a digit and append it to (targetDigits).
 * 3. Set (targetSum) to the integer conversion of (targetDigits).
 * 4. Repeat the aforementioned process but with (firstWord) and (secondWord).
 * 5. Return if the sum of (firstSum) and (secondSum) is equal to (targetSum).
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isSumEqual(
        firstWord = "acb",
        secondWord = "cba",
        targetWord = "cdb",
    )
}

private fun isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean {
    var firstDigits = ""
    var secondDigits = ""
    var targetDigits = ""

    for (char in firstWord) {
        firstDigits += char - 'a'
    }

    for (char in secondWord) {
        secondDigits += char - 'a'
    }

    for (char in targetWord) {
        targetDigits += char - 'a'
    }

    return (firstDigits.toInt() + secondDigits.toInt()) == targetDigits.toInt()
}

//endregion
