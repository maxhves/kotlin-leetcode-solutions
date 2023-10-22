package leetcode.medium

import java.util.*

//region Problem

/**
 * Given an array of integers (temperatures) representing the daily temperatures, return an array (answer)
 * such that (answer[i]) is the number of days you have to wait after the (ith) day to get a warmer
 * temperature. If there is no future day for which this is possible, keep (answer[i] == 0) instead.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 1, 4, 2, 1, 1, 0, 0]
    dailyTemperatures(temperatures = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))

    // Output: [1, 1, 1, 0]
    dailyTemperatures(temperatures = intArrayOf(30, 40, 50, 60))

    // Output: [1, 1, 0]
    dailyTemperatures(temperatures = intArrayOf(30, 60, 90))
}

private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = Stack<Int>()

    for (i in temperatures.indices) {
        val temperature = temperatures[i]

        while (stack.isNotEmpty() && temperatures[stack.peek()] < temperature) {
            val index = stack.pop()
            result[index] = i - index
        }
        stack.push(i)
    }
    return result
}

//endregion
