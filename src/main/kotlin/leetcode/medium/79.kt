package leetcode.medium

//region Problem

/**
 * Given an (m x n) grid of characters (board) and a string (word), return (true) if (word) exists in the
 * grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    exist(
        board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        ),
        word = "ABCCED",
    )
}

private fun exist(board: Array<CharArray>, word: String): Boolean {
    val rows = board.size
    val columns = board[0].size
    val visited = Array(rows) { BooleanArray(columns) }

    fun dfs(row: Int, column: Int, currentIndex: Int): Boolean {
        if (currentIndex == word.length) {
            return true
        }

        if (
            row < 0 ||
            column < 0 ||
            row >= rows ||
            column >= columns ||
            word[currentIndex] != board[row][column] ||
            visited[row][column]
        ) {
            return false
        }

        visited[row][column] = true

        val found = (
            dfs(row, column - 1, currentIndex + 1) ||
            dfs(row, column + 1, currentIndex + 1) ||
            dfs(row - 1, column, currentIndex + 1) ||
            dfs(row + 1, column, currentIndex + 1)
        )

        visited[row][column] = false

        return found
    }

    for (row in 0 until rows) {
        for (column in 0 until columns) {
            if (dfs(row, column, 0)) {
                return true
            }
        }
    }

    return false
}

//endregion
