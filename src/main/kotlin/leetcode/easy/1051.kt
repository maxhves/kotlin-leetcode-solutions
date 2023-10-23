package leetcode.easy

//region Problem

/**
 * A school is trying to take an annual photo of all the students. The students are asked to stand in
 * a single file line in non-decreasing order by height. Let this ordering be represented by the integer
 * array (expected) where (expected[i]) is the expected height of the (ith) student in line.
 *
 * You are given an integer array (heights) representing the current order that the students are standing
 * in. Each (heights[i]) is the height of the (ith) student in the line (0-indexed).
 *
 * Return the number of indices where (heights[i] != expected[i]).
 */

//endregion

//region Steps to solve

/**
 * 1. Store a sorted version of the (heights) array.
 * 2. Iterate over the (heights) array:
 *    - If heights[i] and expected[i] match, continue.
 *    - If they do not match, increase unexpected count by one.
 * 3. Return the resulting answer.
 */

//endregion

//region Solution

private fun main() {
    // Output 3
    heightChecker(heights = intArrayOf(1, 1, 4, 2, 1, 3))

    // Output: 5
    heightChecker(heights = intArrayOf(5, 1, 2, 3, 4))

    // Output: 0
    heightChecker(heights = intArrayOf(1, 2, 3, 4, 5))
}

private fun heightChecker(heights: IntArray): Int {
    val expected = heights.sorted()
    var unexpectedPlacements = 0

    for (i in heights.indices) {
        if (heights[i] != expected[i]) {
            unexpectedPlacements++
        }
    }

    return unexpectedPlacements
}

//endregion
