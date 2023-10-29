package leetcode.medium

//region Problem

/**
 * You are given an (m x n) integer matrix (matrix) with the following two properties:
 *  - Each row is sorted in non-decreasing order.
 *  - The first integer of each row is greater than the last integer of the previous row.
 *
 * Given an integer (target), return (true) if (target) is in (matrix) or (false) otherwise.
 *
 * You must write a solution in (O(log(m * n)) time complexity.
 */

//endregion

//region Steps to solve

/**
 * Consideration:
 *  - Non-decreasing order is ascending order: Binary Search.
 *  - O(log(m *n) suggests Binary Search with a nested loop.
 *  - To narrow the search down quicker we can search through the columns in the matrix.
 *
 * 1. Iterate over each row, so we can perform a binary search on each row.
 * 2. For each row, do the following:
 *     - Initialize a left and right pointer:
 *        - Left: 0 (beginning of the array).
 *        - Right: Index at the end of the array.
 *     - Perform a binary search on the array.
 *     - If we find our target integer, we can return true.
 * 3. Binary search through every row in the (matrix) array.
 * 4. If we reach this point, we should return false.
 *
 * Alternative approach:
 *  - We can treat the 2D matrix as a 1D array, which will make our solution more concise.
 *
 * 1. Initialize two pointers, left and right.
 *     - Left: 0.
 *     - Right: (rowCount * columnCount) - 1.
 * 2. Create a while loop, for while left is smaller than or equal to right:
 *     - Initialize the midpoint:
 *        - (left + right) / 2.
 *     - Get the middle element:
 *        - The "row" index is equal to: midpoint / columnCount.
 *        - The "column" index is equal to: midpoint % columnCount.
 *     - If the element is greater than target:
 *        - Decrease the right pointer to: midpoint - 1.
 *     - If the element is smaller than target:
 *        - Increase the left pointer to: midpoint + 1.
 *     - Else return true.
 * 3. If we reach this point, we can return false.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    searchMatrix(
        matrix = arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60),
        ),
        target = 3
    )
}

// Alternative, and better approach.
private fun searchMatrix1D(matrix: Array<IntArray>, target: Int): Boolean {
    val rowCount = matrix.size
    val columnCount = matrix[0].size

    var left = 0
    var right = (rowCount * columnCount) - 1

    while (left <= right) {
        val midpoint = (left + right) / 2
        val element = matrix[midpoint / columnCount][midpoint % columnCount]

        when {
            element > target -> {
                right = midpoint - 1
            }
            element < target -> {
                left = midpoint + 1
            }
            else -> return true
        }
    }

    return false
}

// Original solution.
private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (row in matrix) {
        if (targetExistsInArray(row, target)) {
            return true
        }
    }

    return false
}

private fun targetExistsInArray(
    array: IntArray,
    target: Int,
): Boolean {
    var left = 0
    var right = array.lastIndex

    while (left <= right) {
        val midpoint = (left + right) / 2
        val element = array[midpoint]

        when {
            element > target -> {
                right = midpoint - 1
            }
            element < target -> {
                left = midpoint + 1
            }
            else -> return true
        }
    }

    return false
}

//endregion
