package leetcode.hard

import java.util.*

//region Problem

/**
 * Given an array of integers (heights) representing the histogram's bar height where the width of each
 * bar is (1), return the area of the largest rectangle in the histogram.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 10
    largestRectangleArea(heights = intArrayOf(2, 1, 5, 6, 2, 3))

    // Output: 4
    largestRectangleArea(heights = intArrayOf(2, 4))
}

private fun largestRectangleArea(heights: IntArray): Int {
    val stack = Stack<Int>()
    var maxArea = 0

    for (i in heights.indices) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            val height = heights[stack.pop()]
            val width = if (stack.isEmpty()) i else i - stack.peek() - 1
            maxArea = maxOf(maxArea, height * width)
        }
        stack.push(i)
    }

    while (!stack.isEmpty()) {
        val height = heights[stack.pop()]
        val width = if (stack.isEmpty()) heights.size else heights.size - stack.peek() - 1
        maxArea = maxOf(maxArea, height * width)
    }

    return maxArea
}

//endregion
