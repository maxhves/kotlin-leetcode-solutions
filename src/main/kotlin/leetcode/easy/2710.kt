package leetcode.easy

//region Problem

/**
 * Given a positive integer (num) represented as a string, return the integer (num) without trailing
 * zeroes as a string.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate from the last index of (num) downTo 0.
 * 2. If the char is '0' do nothing.
 * 3. If the char is not '0' then we can substring num using the current index.
 *
 * 1. We can drop the last (x) chars if they are equal to '0'.
 */

//endregion

//region Solution

private fun main() {
    // Output: "512301
    removeTrailingZeroes(num = "51230100")

    // Output: "123"
    removeTrailingZeroes(num = "123")
}

private fun removeTrailingZeroes(num: String): String {
    return num.dropLastWhile { it == '0' }
}

//endregion