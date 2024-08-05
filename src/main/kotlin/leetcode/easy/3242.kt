package leetcode.easy

//region Problem

/**
 * You are given a 'n x n' 2D array 'grid' containing distinct elements in the range '[0, n^2 - 1]'.
 *
 * Implement the 'neighborSum' class:
 * - 'neighborSum(int [][]grid)' initializes the object.
 * - 'int adjacentSum(int value)' returns the sum of elements which are adjacent neighbors of 'value', that
 *   is either to the top, left, right, or bottom of 'value' in 'grid'.
 * - 'int diagonalSum(int value)' returns the sum of elements which are diagonal neighbors of 'value', that is
 *   either to the top-left, top-right, bottom-left or bottom-right of 'value' in 'grid'.
 */

//endregion

//region Steps to solve

/**
 * - Access the corresponding indexes in the array.
 * - If the index is out of bounds, return 0 as the value instead.
 * - Sum each of the corresponding index values together.
 */

//endregion

//region Solution

private fun main() {
    val neighborSum = NeighborSum(
        grid = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8)
        )
    )

    val sums = intArrayOf(
        // Output: 6
        neighborSum.adjacentSum(value = 1),

        // Output: 16
        neighborSum.adjacentSum(value = 4),

        // Output: 16
        neighborSum.diagonalSum(value = 4),

        // Output: 4
        neighborSum.diagonalSum(value = 8),
    )

    val debugLine = sums
}

private class NeighborSum(val grid: Array<IntArray>) {
    private val gridRows = grid.lastIndex
    private val gridColumns = grid[0].lastIndex

    private fun gridIndexOf(value: Int): Pair<Int, Int> {
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val currentValue = grid[i][j]

                if (currentValue == value) {
                    return i to j
                }
            }
        }
        return -1 to -1
    }

    fun adjacentSum(value: Int): Int {
        val valueIndex = gridIndexOf(value = value)

        val adjacentValues = intArrayOf(
            // Top
            if (valueIndex.first !in 1..gridRows) {
                0
            } else {
                grid[valueIndex.first - 1][valueIndex.second]
            },

            // Right
            if (valueIndex.second !in 0 until gridColumns) {
                0
            } else {
                grid[valueIndex.first][valueIndex.second + 1]
            },

            // Bottom
            if (valueIndex.first !in 0 until gridRows) {
                0
            } else {
                grid[valueIndex.first + 1][valueIndex.second]
            },

            // Left
            if (valueIndex.second !in 1..gridColumns) {
                0
            } else {
                grid[valueIndex.first][valueIndex.second - 1]
            },
        )

        return adjacentValues.fold(0) { i, acc -> acc + i }
    }

    fun diagonalSum(value: Int): Int {
        val valueIndex = gridIndexOf(value = value)

        val diagonalValues = intArrayOf(
            // Top Left
            if (valueIndex.first in 1..gridRows) {
                if (valueIndex.second in 1..gridColumns) {
                    grid[valueIndex.first - 1][valueIndex.second - 1]
                } else {
                    0
                }
            } else {
                0
            },

            // Top Right
            if (valueIndex.first in 1..gridRows) {
                if (valueIndex.second in 0 until gridColumns) {
                    grid[valueIndex.first - 1][valueIndex.second + 1]
                } else {
                    0
                }
            } else {
                0
            },

            // Bottom Right
            if (valueIndex.first in 0 until gridRows) {
                if (valueIndex.second in 0 until gridColumns) {
                    grid[valueIndex.first + 1][valueIndex.second + 1]
                } else {
                    0
                }
            } else {
                0
            },

            // Bottom Left
            if (valueIndex.first in 0 until gridRows) {
                if (valueIndex.second in 1..gridColumns) {
                    grid[valueIndex.first + 1][valueIndex.second - 1]
                } else {
                    0
                }
            } else {
                0
            },
        )

        return diagonalValues.fold(0) { i, acc -> acc + i }
    }
}

//endregion
