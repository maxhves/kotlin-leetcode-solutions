package leetcode.medium

//region Problem

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is
 * either directly below or diagonal left/right. Specifically, the next element from position
 * (row, col) will be (row + 1, col - 1), (row + 1, col) or (row + 1, col + 1).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - To calculate all path eventualities, we should use a recursive DFS approach.
 * - We can iterate over the first row in the matrix, and for each element in that first row, we
 *   should make a call to a recursive function that will calculate the sum of the path.
 * - We need to return the minimum path, which we can do by keeping a minimumPathSum variable, and
 *   updating it for each path, for each element in the first row.
 * - The DFS function should have the following parameters:
 *   - currentRow: Int, the current row we are checking.
 *   - currentColumn: Int, the current column we are checking.
 *   - path: IntArray, the current path so far.
 * - The DFS function should return an Int that is the current path sum.
 * - The DFS function has some base cases:
 *   - If currentRow is out of bounds, return 0.
 *   - If currentColumn is out of bounds, return 0.
 *   - If matrix[currentRow][currentColumn] is in path, return 0.
 * - Inside the DFS function we have some choices to make:
 *   - Ensure the base cases are taken care of.
 *   - We have three choices to make:
 *     - Move to the element directly below.
 *     - Move to the element diagonally left and below.
 *     - Move to the element diagonally right and below.
 *   - At each level we should return the minimum value of each choice.
 *   - The value will be the sum of the path in that branch.
 */

//endregion

//region Solution

private fun main() {
    // Output: 13
    minFallingPathSum(
        matrix = arrayOf(
            intArrayOf(2, 1, 3),
            intArrayOf(6, 5, 4),
            intArrayOf(7, 8, 9),
        )
    )
}

private fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val rows = matrix.size
    val columns = matrix[0].size

    val cache = Array(rows) { arrayOfNulls<Int>(columns) }

    fun dfs(currentRow: Int, currentColumn: Int): Int {
        if (currentRow >= rows) {
            return Int.MAX_VALUE
        }

        if (currentColumn < 0 || currentColumn >= columns) {
            return Int.MAX_VALUE
        }

        if (cache[currentRow][currentColumn] != null) {
            return cache[currentRow][currentColumn] ?: 0
        }

        val currentElement = matrix[currentRow][currentColumn]

        if (currentRow == matrix.lastIndex) {
            return currentElement
        }

        val directBelow = dfs(currentRow + 1, currentColumn)
        val diagonalLeft = dfs(currentRow + 1, currentColumn - 1)
        val diagonalRight = dfs(currentRow + 1, currentColumn + 1)

        val result = minOf(directBelow, diagonalLeft, diagonalRight) + currentElement
        cache[currentRow][currentColumn] = result

        return result
    }

    var minimumPathSum = Int.MAX_VALUE

    for (i in matrix[0].indices) {
        minimumPathSum = minOf(minimumPathSum, dfs(0, i))
    }

    return minimumPathSum
}

//endregion
