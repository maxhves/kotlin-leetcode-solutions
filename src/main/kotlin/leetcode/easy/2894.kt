package leetcode.easy

//region Problem

/**
 * You are given positive integers (n) and (m).
 *
 * Define two integers, (num1) and (num2), as follows:
 *  - (num1): The sum of all integers in the range ([1, n]) that are not divisible by (m).
 *  - (num2): The sum of al integers in the range ([1, n]) that are divisible by (m).
 *
 * Return the integer (num1 - num2).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to split a series of numbers that are split based on whether they are divisible by (m).
 *
 * 1. Initialize some variables:
 *     - (num1) a mutable integer, at 0.
 *     - (num2) a mutable integer, at 0.
 * 2. Iterate from 1 upTo (n); and for each iteration:
 *     - If the element is divisible by (m):
 *        - Sum the element onto (num2).
 *     - Otherwise, sum the element to (num1).
 * 3. Return (num1) - (num2).
 */

//endregion

//region Solution

private fun main() {
    // Output: 19
    differenceOfSums(n = 10, m = 3)

    // Output: 15
    differenceOfSums(n = 5, m = 6)
}

private fun differenceOfSums(n: Int, m: Int): Int {
    var num1 = 0
    var num2 = 0

    for (i in 1 .. n) {
        if (i % m == 0) {
            num2 += i
        } else {
            num1 += i
        }
    }

    return num1 - num2
}

//endregion
