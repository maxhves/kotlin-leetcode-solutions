package leetcode.easy

//region Problem

/**
 * You are given an array of positive integers 'nums'.
 *
 * Alice and Bob are playing a game. In the game, Alice can choose either all single-digit numbers or all
 * double-digit numbers from 'nums', and the rest of the numbers are given to Bob. Alice wins if the sum of
 * her numbers is strictly greater than the sum of Bob's numbers.
 *
 * Return 'true' if Alice can win this game, otherwise, return 'false'.
 */

//endregion

//region Steps to solve

/**
 * - Keep track of two variables:
 *   - singleDigitTotal: the sum of all single-digit entries.
 *   - doubleDigitTotal: the sum of all double-digit entries.
 * - Iterate over the 'nums' array:
 *   - We can quickly check if the number is single-digit or double-digit by converting the number to a string
 *     and checking the length of the string.
 *   - Add each entry to the respective property.
 * - Return if singleDigitTotal and doubleDigitTotal are equal in value.
 */

//endregion

//region Solution

private fun main() {
    // Output: false
    canAliceWin(nums = intArrayOf(1, 2, 3, 4, 10))

    // Output: true
    canAliceWin(nums = intArrayOf(1, 2, 3, 4, 5, 14))
}

private fun canAliceWin(nums: IntArray): Boolean {
    var singleDigitTotal = 0
    var doubleDigitTotal = 0

    for (num in nums) {
        if (num.toString().length > 1) {
            doubleDigitTotal += num
        } else {
            singleDigitTotal += num
        }
    }

    return singleDigitTotal != doubleDigitTotal
}

//endregion
