package leetcode.medium

//region Problem

/**
 * We have a wooden plank of the length (n) units. Some ants are walking on the plank, each ant moves with
 * a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.
 *
 * When two ants are moving in two different directions meet at some point, they change their directions
 * and continue moving again. Assume changing directions does not take any additional time.
 *
 * When an ant reaches one end of the plank at a time (t), it falls out of the plank immediately.
 *
 * Given an integer (n) and two integer arrays (left) and (right), the positions of the ants moving to the
 * left and right, return the moment when the last ant(s) fall out of the plank.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We must find out how long it takes the last ant(s) to leave the "plank".
 *  - Could we check the lowest number in right, and the highest in left?
 *  - Check how far away they are from the last/first index?
 *
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    getLastMoment(n = 4, left = intArrayOf(4, 3), right = intArrayOf(0, 1))
}

private fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
    val leftMax = left.maxOrNull() ?: 0
    val rightMin = right.minOrNull() ?: n
    return maxOf(leftMax, (n - rightMin))
}

//endregion
