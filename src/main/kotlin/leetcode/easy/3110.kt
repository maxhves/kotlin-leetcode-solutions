import kotlin.math.abs

//region Problem

/**
 * You are given a string 's'. The score of a string is defined as the sum of the absolute difference between the
 * ASCII values of adjacent characters.
 *
 * Return the score of 's'.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over each character, store the current char's ASCII value.
 * - If we are at index 1 or greater:
 *   - Minus the previous number with the current number.
 *   - Add the result to a final result value.
 * - Return the final result.
 */

//endregion

//region Solution

private fun main() {
    // Output: 13
    scoreOfString(s = "hello")

    // Output: 50
    scoreOfString(s = "zaz")
}

private fun scoreOfString(s: String): Int {
    var score = 0
    var previousAsciiValue = -1

    for (char in s) {
        val currentAsciiValue = char.code

        if (previousAsciiValue > -1) {
            score += abs(previousAsciiValue - currentAsciiValue)
        }
        previousAsciiValue = currentAsciiValue
    }

    return score
}

//endregion
