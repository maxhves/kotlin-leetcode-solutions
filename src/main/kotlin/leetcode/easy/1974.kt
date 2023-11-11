package leetcode.easy

import kotlin.math.abs

//region Problem

/**
 * There is a special typewriter with lowercase English letters ('a') to ('z') arranged in a circle with a
 * pointer. A character can only be typed if the pointer is pointing to that character. The pointer is
 * initially pointing to the character ('a').
 *
 * Each second, you may perform one of the following operations:
 * - Move the pointer one character counterclockwise or clockwise.
 * - Type the character the pointer is currently on.
 *
 * Given a string (word), return the minimum number of second to type out the characters in word.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - Presumably there are some operations that are quicker to go backwards rather than forwards.
 * - We should calculate for each letter if it's quicker to cycle forward or backward and use the min.
 * - How do we know which is quicker?
 *   - Alphabet is from 1 to 26.
 *   - Example: (C: 3) to (T: 20).
 *     - Forwards: Difference of 17.
 *     - Backward: Difference of:
 *       - (C: 3) to (A: 1) = 2.
 *       - (Z: 26) to (T: 20) = 6.
 *       - Total difference: 8.
 *
 * Steps:
 * 1. Initialize some variables:
 *    - (seconds): Int, a count of the seconds used.
 *    - (previous): Int, the previous character in the sequence as it's integer value.
 * 2. Iterate over each (char) in (word):
 *    - Convert (char) to its integer counterpart.
 *    - Calculate the difference going (forward) from (previous) to (current).
 *    - Calculate the difference going (backward) from (previous) to (current).
 *    - Increase (seconds) by the min of (forward, backward).
 * 3. Return (seconds).
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    minTimeToType(word = "abc")

    // Output: 7
    minTimeToType(word = "bza")
}

private fun minTimeToType(word: String): Int {
    var seconds = 0
    var previous = 'a'

    for (char in word) {
        val forward = abs(char - previous)
        val backward = abs(26 - forward)

        seconds += minOf(forward, backward)
        previous = char
    }

    return seconds + word.length
}

//endregion
