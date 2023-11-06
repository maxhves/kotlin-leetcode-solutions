package leetcode.easy

//region Problem

/**
 * You are given two non-negative integers (num1) and (num2).
 *
 * In one operation, if (num1 >= num2) you must subtract (num2) from (num1), otherwise subtract (num1)
 * from (num2).
 *  - For example, if (num1 = 5) and (num2 = 4), subtract (num2) from (num1), thus obtaining (num1 = 1) and
 *    (num2 = 4). However, if (num1 = 4) and (num2 = 5), after one operation, (num1 = 4) and (num2 = 1).
 *
 * Return the number of operations required to make either (num1 = 0) or (num2 = 0).
 */

//endregion

//region Steps to solve

/**
 * 1. Initialize three variables:
 *     - (number1): set to (num1).
 *     - (number2): set to (num2).
 *     - (operationCount): set to 0.
 * 2. While (number1 > 0 and number2 > 0):
 *     - If (number1) is greater than or equal to (number2):
 *        - (number1) = (number1) - (number2).
 *     - Otherwise:
 *        - (number2) = (number2) - (number1).
 * 3. Ultimately return (operationCount).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    countOperations(num1 = 2, num2 = 3)

    // Output: 1
    countOperations(num1 = 10, num2 = 10)
}

private fun countOperations(num1: Int, num2: Int): Int {
    var number1 = num1
    var number2 = num2
    var operationCount = 0

    while (number1 > 0 && number2 > 0) {
        if (number1 >= number2) {
            number1 -= number2
        } else {
            number2 -= number1
        }

        operationCount++
    }

    return operationCount
}

//endregion
