package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed string `s` that has lowercase English letters in its even indices and digits
 * in its odd indices.
 *
 * There is a function `shift('a', 5) = 'f'`.
 *
 * For every odd index `i`, you want to replace the digit `s[i]` with `shift(s[i-1], s[i])`.
 *
 * Return `s` after replacing all digits. It is guaranteed that `shift(s[i-1], s[i])` will never exceed
 * `'z'`.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the string.
 *    - Step by 2, to cut down on time.
 * 2. Take s[i] (the number) and s[i - 1] (the character).
 *    - Run through the shift function.
 * 3. Shift function will:
 *    - Get index of letter.
 *    - Increase index by number.
 *    - Return new letter.
 * 4. Add results to new string.
 * 5. Return resulting string.
 */

//endregion

//region Solution

private fun main() {
    // Output = "abcdef"
    replaceDigits(s = "a1c1e1")

    // Output = "abbdcfdhe"
    replaceDigits(s = "a1b2c3d4e")
}

private fun replaceDigits(s: String): String {
    val result = s.toCharArray()

    for (i in 1 .. s.lastIndex step 2) {
        result[i] = s[i - 1] + (s[i] - '0')
    }

    return result.joinToString("")
}

//endregion