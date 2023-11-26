package leetcode.medium

import kotlin.math.max

//region Problem

/**
 * You are given a binary matrix (matrix) of size (m x n), and you are allowed to rearrange the columns
 * of the (matrix) in any order.
 *
 * Return the largest submatrix within (matrix) where every element of the submatrix is (1) after
 * reordering columns optimally.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We should rearrange each column so that the 1's are prioritized.
 * - Only columns can be rearranged, and not single rows.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    largestSubmatrix(
        matrix = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
        ),
    )
}

private fun largestSubmatrix(matrix: Array<IntArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    var ans = 0

    for (row in 0 until m) {
        for (col in 0 until n) {
            if (matrix[row][col] != 0 &&  row > 0) {
                matrix[row][col] += matrix[row - 1][col]
            }
        }

        val currRow = matrix[row].clone()
        currRow.sort()

        for (i in currRow.indices) {
            ans = max(ans, currRow[i] * (n - i))
        }
    }

    return ans
}

//endregion
