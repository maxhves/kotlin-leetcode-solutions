package leetcode.medium

//region Problem

/**
 * There is an (n x n) grid, with the top-left cell at (0, 0) and the bottom-right cell at (n - 1, n - 1).
 * You are given the integer (n) and an integer array (startPos) where  (startPos = [start row, start col])
 * indicates that a robot is initially at cell (start row, start col).
 *
 * You are also given a 0-indexed string (s) of length (m) where (s[i]) is the (ith) instruction for the
 * robot: ('L') move left, ('R') move right, ('U') move up and ('D') move down.
 *
 * The robot can begin executing from any (ith) instruction in (s). It executes the instructions one by
 * one toward the end of (s) but it stops if either of these conditions are met:
 * - The next instruction will move the robot off the grid.
 * - There are no more instructions left to execute.
 *
 * Return an array (answer) of length (m) where (answer[i]) is the number of instructions the robot can
 * execute if the robot begins executing from the (itH) instruction in (s).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialise and (answer) Int array set to the length of (s).
 * - Iterate over the instruction string (s):
 *   - Initialise an Int (validMoves).
 *   - Create an inner loop again from (i) to end of (s).
 *     - If (R), add 1 to (x).
 *     - If (L), minus 1 to (x).
 *     - If (U), minus 1 to (y).
 *     - If (D), add 1 to (y).
 *     - Check if new position is in the range (n - 1) for both axis.
 *     - If it is a valid move then increment (validMoves).
 *   - Set (answer[i]) to (validMoves).
 * - Return (answer).
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 5, 4, 3, 1, 0]
    exampleInstructions(
        n = 3,
        startPos = intArrayOf(0, 1),
        s = "RRDDLU",
    )
}

private fun exampleInstructions(n: Int, startPos: IntArray, s: String): IntArray {
    val answer = IntArray(s.length)

    for (i in 0..s.lastIndex) {
        var validPositions = 0
        var currentX = startPos[1]
        var currentY = startPos[0]

        for (j in i..s.lastIndex) {
            val instruction = s[j]

            when (instruction) {
                'R' -> {
                    currentX++
                }
                'L' -> {
                    currentX--
                }
                'U' -> {
                    currentY--
                }
                'D' -> {
                    currentY++
                }
            }

            if (currentX !in 0 until n || currentY !in 0 until n) {
                break
            } else {
                validPositions++
            }
        }

        answer[i] = validPositions
    }

    return answer
}

//endregion
