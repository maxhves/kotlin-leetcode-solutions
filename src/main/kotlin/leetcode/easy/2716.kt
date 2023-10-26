package leetcode.easy

//region Problem

/**
 * Given a 0-indexed string (s), repeatedly perform the following operation any number of times:
 *  - Choose an index (i) in the string, and let (c) be the character in position (i). Delete the closest
 *    occurrence of (c) to the left of (i) if any and the closest occurrence of (c) to the right of (i)
 *    if any.
 *
 * Your task is to minimize the length of (s) by performing the above operation any number of times.
 *
 * Return an integer denoting the length of the minimized string.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - Are we simply returning the distinct value count?
 *
 * 1. Convert (s) into a char array.
 * 2. Take only the distinct values of the array.
 * 3. Return the count of the distinct values.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    minimizedStringLength(s = "aabc")

    // Output: 3
    minimizedStringLength(s = "cbbd")

    // Output: 2
    minimizedStringLength(s = "dddaaa")
}

private fun minimizedStringLength(s: String): Int {
    return s.toHashSet().count()
}

//endregion
