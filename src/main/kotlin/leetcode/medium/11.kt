package leetcode.medium

//region Problem

/**
 * You are given an integer array (height) of length (n). There are (n) vertical lines drawn such that
 * the two endpoints of the (ith) line are (i, 0) and (i, height[i]).
 *
 * Find the two lines that together with the x-axis form a container, such that the container contains
 * the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */

//endregion

//region Steps to solve

/**
 * Things to remember:
 *  - Area = height * width:
 *    - In this case it is the height of the second-tallest element * index difference.
 *  - Two pointers.
 *
 * 1. Initialize two pointers, left and right:
 *    - Left: 0.
 *    - Right: height.lastIndex.
 * 2. While the left pointer is smaller than the right pointer, run a loop:
 *    - Calculate the area we can contain with these two pointers:
 *      - area = minOf(height[left], height[right]) * (right - left).
 *    - If area is greater than the current maxArea, this is the new maxArea.
 * 3. We need to move our pointers based on which height is greater, so we can maximize the next area:
 *    - If height[left] is greater than height[right]:
 *      - Decrease right.
 *    - Else
 *      - Increase left.
 * 4. Ultimately, return maxArea.
 */

//endregion

//region Solution

private fun main() {
    // Output: 49
    maxArea(height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))

    // Output: 1
    maxArea(height = intArrayOf(1, 1))

    // Output: 36
    maxArea(height = intArrayOf(2, 3, 10, 5, 7, 8, 9))
}

private fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var maxArea = 0

    while (left < right) {
        val area = minOf(height[left], height[right]) * (right - left)
        maxArea = maxOf(maxArea, area)

        if (height[left] > height[right]) {
            right--
        } else {
            left++
        }
    }

    return maxArea
}

//endregion
