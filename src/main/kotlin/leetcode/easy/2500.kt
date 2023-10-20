package leetcode.easy

//region Problem

/**
 * You are given an (m x n) matrix (grid) consisting of positive integers.
 *
 * Perform the following operation until (grid) becomes empty:
 *  - Delete the element with the greatest value from each row. If multiple such elements exist,
 *    delete any of them.
 *  - Add the maximum of deleted elements to the answer.
 *
 * Note: the number of columns decreases by one after each operation.
 *
 * Return the answer after performing the operations described above.
 */

//endregion

//region Steps to solve

/**
 * 1.
 */

//endregion

//region Solution

private fun main() {
    // Output: 8
    deleteGreatestValue(
        grid = arrayOf(
            intArrayOf(1, 2, 4),
            intArrayOf(3, 3, 1),
        )
    )

    // Output: 10
    deleteGreatestValue(
        grid = arrayOf(
            intArrayOf(10),
        )
    )
}

private fun deleteGreatestValue(grid: Array<IntArray>): Int {
    val sortedGrid = grid.map { it.sorted() }
    var answer = 0

    for (column in 0 until grid[0].size) {
        var maxElement = 0

        for (row in 0 until grid.size) {
            maxElement = maxOf(maxElement, sortedGrid[row][column])
        }

        answer += maxElement
    }

    return answer
}

//endregion
