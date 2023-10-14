package leetcode.easy

//region Problem

/**
 * Given a positive integer `n`, find the pivot integer `x` such that:
 *  - The sum of all elements between `1` and `x` inclusively equals the sum of all the elements between
 *    `x` and `n` inclusively.
 *
 * Return the pivot integer `x`. If no such integer exists, return `-1`. It is guaranteed that there will
 * be at most one pivot index for the given input.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate from `1` to `n`.
 * 2. Sum from `1` to `x`.
 * 3. Sum from `x` to `n`.
 * 4. If we reach a point where the sums match:
 *    - Return the element.
 *    - Else return `-1`.
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    pivotInteger(n = 8)

    // Output: 1
    pivotInteger(n = 1)

    // Output: -1
    pivotInteger(n = 4)
}

private fun pivotInteger(n: Int): Int {
    var result = -1
    var left = 0
    var right = 0

    for (i in n downTo 1) {
        right += i
        left = i * (i + 1) / 2

        if (left == right) {
            result = i
            break
        }
    }

    return result
}

//endregion