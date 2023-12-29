package leetcode.hard

import kotlin.math.min

//region Problem

/**
 * Run-length encoding is a string compression method that works by replacing consecutive identical
 * characters (repeated 2 or more times0 with the concatenation of the character and the number marking
 * the count of the characters (length of the run). For example, to compress the string "aabccc" we
 * replace "aa" by "a2" and replace "ccc" by "c3". This the compressed string becomes "a2bc3".
 *
 * Notice that in this problem, we are not adding '1' after single characters.
 *
 * Given a string (s) and an integer (k). You need to delete at most (k) characters from (s) such that
 * the run-length encoded version of (s) has minimum length.
 *
 * Find the minimum length of the run-length encoded version of (s) after deleting at most (k)
 * characters.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We need to create a recursive function (count) with the following parameters:
 *   - (index): the current index in (s) we are evaluating.
 *   - (deletionsLeft): how many possible deletions we have left.
 *   - (previousCharacter): the previous character we evaluated.
 *   - (previousRun): the current "run" so far.
 *
 * - Inside the (count) function we do the following:
 *   - Check out base cases:
 *     - If (deletionsLeft) is smaller than 0: return Int.MAX_VALUE (we want this branch to not be
 *       considered under any circumstances).
 *     - If (index) is greater than the last index in (s): we return 0.
 *   - Check if the current char is equal to (previousChar):
 *     - If it is equal:
 *       - We should return a recursive call to (count) with the following arguments:
 *         - index = index + 1.
 *         - deletionsLeft = (k).
 *         - previousCharacter = current character.
 *         - previousRun = previousRun + 1.
 *       - We also need to add an extra value to account for "a9" going to "a10" (adding an extra digit)
 *         - If (previousRun) is equal to 1, 9 or 99 then we add 1 to the recursive call.
 *     - If it is not equal:
 *       - Return the minimum of the recursive call to (count) where:
 *         - We delete the current char, passing in (previousChar) as the previous char.
 *         - We do NOT delete the current char, passing in the current char as the previous char.
 *           - Note here that we need to plus 1, since the length has increased.
 *
 * - We call the function passing in:
 *   - index = 1.
 *   - deletionsLeft = (k).
 *   - previousCharacter = ''.
 *   - previousRun = 1.
 *
 * - Return the result of the recursive function call.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    getLengthOfOptimalCompression(s = "aaabcccd", k = 2)
}

private fun getLengthOfOptimalCompression(s: String, k: Int): Int {
    data class CacheKey(
        val index: Int,
        val deletionsLeft: Int,
        val previousChar: Char,
        val previousRun: Int,
    )

    val cache = HashMap<CacheKey, Int>()

    fun count(
        index: Int,
        deletionsLeft: Int,
        previousChar: Char,
        previousRun: Int,
    ): Int {
        val cacheKey = CacheKey(index, deletionsLeft, previousChar, previousRun)
        if (cacheKey in cache) {
            return cache.getOrDefault(cacheKey, 0)
        }

        if (deletionsLeft < 0) {
            return Int.MAX_VALUE
        }

        if (index == s.length) {
            return 0
        }

        var result = 0
        val currentChar = s[index]

        if (currentChar == previousChar) {
            val increment = if (previousRun in setOf(1, 9, 99)) 1 else 0
            result = count(index + 1, deletionsLeft, previousChar, previousRun + 1) + increment
        } else {
            result = min(
                count(index + 1, deletionsLeft - 1, previousChar, previousRun),
                count(index + 1, deletionsLeft, currentChar, 1) + 1
            )
        }

        cache[cacheKey] = result
        return result
    }

    return count(0, k, ' ', 0)
}

//endregion
