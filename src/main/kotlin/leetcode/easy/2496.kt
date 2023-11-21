package leetcode.easy

//region Problem

/**
 * The value of an alphanumeric string can be defined as:
 * - the numeric representation of the string in base (10), if it comprises digits only.
 * - The length of the string, otherwise.
 *
 * Given an array (strs) of alphanumeric strings, return the maximum value of any strings in (strs).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Attempt to convert each string to an integer.
 * - If the conversion fails, the string doesn't only contain digits.
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    maximumValue(
        strs = arrayOf("alic3", "bob", "3", "4", "00000"),
    )
}

private fun maximumValue(strs: Array<String>): Int {
    var currentMaxValue = Int.MIN_VALUE

    for (element in strs) {
        val elementAsInt = element.toIntOrNull()
        currentMaxValue = maxOf(currentMaxValue, elementAsInt ?: element.length)
    }

    return currentMaxValue
}

//endregion
