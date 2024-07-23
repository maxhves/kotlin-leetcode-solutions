package leetcode.easy

//region Problem

/**
 * An integer divisible by the sum of its digits is said to be a Harshad number. You are given an integer 'x'.
 * Return the sum of the digits of 'x' if 'x' is a Harshad number, otherwise return '-1'.
 */

//endregion

//region Steps to solve

/**
 * - Use the remainder operator '%' with 10 to get the last digit.
 * - Divide the current number by 10.
 * - Repeat this process until the current number is 0.
 * - Add each remainder digit to a sum.
 * - Return if 'x' is divisible by the sum we have kept.
 */

//endregion

//region Solution

private fun main() {
    // Output: 9
    sumOfTheDigitsOfHarshadNumber(x = 18)

    // Output: -1
    sumOfTheDigitsOfHarshadNumber(x = 23)
}

private fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
    var currentNumber = x
    var digitSum = 0

    while (currentNumber > 0) {
        digitSum += currentNumber % 10
        currentNumber /= 10
    }

    return if (x % digitSum == 0) digitSum else -1
}

//endregion
