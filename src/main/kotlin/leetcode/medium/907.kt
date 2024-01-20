package leetcode.medium

import java.util.*

//region Problem

/**
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous)
 * sub array of arr. Since the answer may be large, return the answer modulo 10^9 + 7.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 17
    sumSubarrayMins(arr = intArrayOf(3, 1, 2, 4))

    // Output: 444
    sumSubarrayMins(arr = intArrayOf(11, 81, 94, 43, 3))
}

private fun sumSubarrayMins(arr: IntArray): Int {
    val modulo = 1_000_000_007
    var minValue = 0L
    val stack = Stack<Int>()
    stack.push(-1)

    for (i in 0..arr.size) {
        val currentElement = if (i in arr.indices) arr[i] else 0

        while (stack.peek() != -1 && currentElement < arr[stack.peek()]) {
            val index = stack.pop()

            val left = index - stack.peek()
            val right = i - index

            minValue += (left * right * arr[index].toLong()) % modulo
            minValue %= modulo
        }

        stack.push(i)
    }

    return minValue.toInt()
}

//endregion
