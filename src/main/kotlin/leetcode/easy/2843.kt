package leetcode.easy

//region Problem

/**
 * You are given two positive integers (low) and (high).
 *
 * An integer (x) consisting of (2 * n) digits is symmetric if the sum of the first (n) digits of (x)
 * is equal to the sum of the last (n) digits of (x). Numbers with an odd number of digits are never
 * symmetric.
 *
 * Return the number of symmetric integers in the range ([low, high]).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We must check in the range of (low) to (high).
 *  - If the number is of odd length, it is immediately not a match.
 *
 * 1. Create an answer integer to hold the result.
 * 2. Iterate from (left) to (right):
 *    - For each element (i):
 *      - Check the number of digits in the number.
 *      - If odd; break.
 *      - If even:
 *        - Start taking digits from the array and add them to a sum.
 *        - When we are half way, store the sum of the rest of the digits in another sum.
 *        - Compare the sums, if they match, add this number to our result count.
 * 3. Continue the loop for all numbers.
 * 4. Return the resulting count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 9
    countSymmetricIntegers(low = 1, high = 100)

    // Output: 4
    countSymmetricIntegers(low = 1200, high = 1230)
}

private fun countSymmetricIntegers(low: Int, high: Int): Int {
    var result = 0

    for (i in low .. high) {
        val digitCount = i.toString().length

        if (digitCount % 2 == 0) {
            var digitsLeft = i
            var firstSum = 0
            var secondSum = 0

            for (j in 0 .. digitCount) {
                val currentDigit = digitsLeft % 10
                digitsLeft /= 10

                if (j < digitCount / 2) {
                    firstSum += currentDigit
                } else {
                    secondSum += currentDigit
                }
            }

            if (firstSum == secondSum) {
                result++
            }
        }
    }

    return result
}

//endregion
