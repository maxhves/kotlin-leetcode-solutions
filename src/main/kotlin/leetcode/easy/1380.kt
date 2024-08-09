package leetcode.easy

//region Problem

/**
 * Given an 'm x n' matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in
 * its column.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over each row and column in the matrix.
 * - Store the minimum values of each row in an array.
 * - Store the maximum values of each column in an array.
 * - The index of each value corresponds to the row/column.
 * - Iterate over the matrix again and check if the current element is the minimum of its row and the
 *   maximum of its column.
 * - If the conditions are met successfully, add this element to a result array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [15]
    luckyNumbers(
        matrix = arrayOf(
            intArrayOf(3, 7, 8),
            intArrayOf(9, 11, 13),
            intArrayOf(15, 16, 17),
        )
    )

    // Output: [12]
    luckyNumbers(
        matrix = arrayOf(
            intArrayOf(1, 10, 4, 2),
            intArrayOf(9, 3, 8, 7),
            intArrayOf(15, 16, 17, 12),
        )
    )

    // Output: [7]
    luckyNumbers(
        matrix = arrayOf(
            intArrayOf(7, 8),
            intArrayOf(1, 2),
        )
    )
}

private fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
    val rowCount = matrix.size
    val columnCount = matrix[0].size

    val minimumRowValues = IntArray(rowCount) { Int.MAX_VALUE }
    val maximumColumnValues = IntArray(columnCount) { Int.MIN_VALUE }
    val luckyNumbers = mutableListOf<Int>()

    // Initial pass to check minimums and maximums.
    for (row in 0 until rowCount) {
        for (column in 0 until columnCount) {
            minimumRowValues[row] = minOf(minimumRowValues[row], matrix[row][column])
            maximumColumnValues[column] = maxOf(maximumColumnValues[column], matrix[row][column])
        }
    }

    // Second pass to find lucky numbers.
    for (row in 0 until rowCount) {
        for (column in 0 until columnCount) {
            val currentElement = matrix[row][column]

            if (currentElement <= minimumRowValues[row] && currentElement >= maximumColumnValues[column]) {
                luckyNumbers.add(currentElement)
            }
        }
    }

    return luckyNumbers
}

//endregion
