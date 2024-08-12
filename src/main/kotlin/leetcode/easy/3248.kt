package leetcode.easy

//region Problem

/**
 * There is a snake in an 'n x n' matrix 'grid' and can move in four possible directions. Each cell in the
 * 'grid' is identified by the position: 'grid[i][j] = (i * n) + j'.
 *
 * The snake starts at cell 0 and follows a sequence of commands.
 *
 * You are given an integer 'n' representing the size of the 'grid' and an array of strings 'commands' where
 * each 'command[i]' is either '"UP"', '"RIGHT"', '"DOWN"', and '"LEFT"'. It's guaranteed that the snake will
 * remain within 'grid' boundaries throughout its movement.
 *
 * Return the position of the final cell where the snake ends up after executing 'commands'.
 */

//endregion

//region Steps to solve

/**
 * - Commands should be mapped to an operation.
 * - UP: Plus 1 on Y axis.
 * - RIGHT: Plus 1 on X axis.
 * - DOWN: Minus 1 on Y axis.
 * - LEFT: Minus 1 on X axis.
 * - We can simply store the current row and column position in a variable.
 * - Iterate over each command and update the row/column accordingly.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    finalPositionOfSnake(n = 2, commands = listOf("RIGHT", "DOWN"))

    // Output: 1
    finalPositionOfSnake(n = 3, commands = listOf("DOWN", "RIGHT", "UP"))
}

private fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
    var row = 0
    var column = 0

    for (command in commands) {
        when (command) {
            "UP" -> row--
            "DOWN" -> row++
            "RIGHT" -> column++
            "LEFT" -> column--
        }
    }

    return row * n + column
}

//endregion
