package leetcode.easy

//region Problem

/**
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of it's
 * moves, jude if this robot ends up at (0, 0) after it completes its moves.
 *
 * You are given a string (moves) that represents the move sequence of the robot where (moves[i]) represents
 * the (ith) move. Valid moves are ('R') right, ('L') left, ('U') up and ('D') down.
 *
 * Return (true) if the robot returns to the origin after it finishes all of its moves, or false otherwise.
 *
 * Note: The way the robot is facing is irrelevant.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - (0, 0) == (x, y)
 * - Right: Increase (x) by 1.
 * - Left: Decrease (x) by 1.
 * - Up: Decrease (y) by 1.
 * - Down: Increase (y) by 1.
 *
 * 1. Iterate over the characters in the (moves) string.
 * 2. For each (move):
 *    - Check which instruction it is.
 *    - Follow the pattern as described in the considerations.
 *    - Update the current position of the robot.
 * 3. Return (true) if the robot ends up at (0, 0).
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    judgeCircle(moves = "UD")

    // Output: false
    judgeCircle(moves = "LL")
}

private fun judgeCircle(moves: String): Boolean {
    var robotX = 0
    var robotY = 0

    for (char in moves) {
        when (char) {
            'R' -> robotX++
            'L' -> robotX--
            'U' -> robotY--
            'D' -> robotY++
        }
    }

    return robotX == 0 && robotY == 0
}

//endregion
