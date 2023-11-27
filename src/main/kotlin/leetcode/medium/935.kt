package leetcode.medium

//region Problem

/**
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally,
 * or two squares horizontally and one square vertically (with both forming the shape of an L). The possible
 * movements of chess knight are shown in this diagram.
 *
 * A chess knight can move as indicated in the chess diagram.
 *
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell
 * (i.e. blue cell).
 *
 * Given an integer (n), return how many distinct phone number of length (n) we can dial.
 *
 * You are allowed to place the knight on any numeric cell initially, and then you should perform (n - 1)
 * jumps to dial a number of length (n). All jumps should be valid knight jumps.
 *
 * As the answer may be very large, return the answer modulo (10^9 + 7).
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 10
    knightDialer(n = 10)
}

private const val MODULO = 1_000_000_007
private val jumps = listOf(
    intArrayOf(4, 6),
    intArrayOf(6, 8),
    intArrayOf(7, 9),
    intArrayOf(4, 8),
    intArrayOf(3, 9, 0),
    intArrayOf(),
    intArrayOf(1, 7, 0),
    intArrayOf(2, 6),
    intArrayOf(1, 3),
    intArrayOf(2, 4),
)

private fun knightDialer(n: Int): Int {
    var moves = LongArray(10) { 1L }
    for (i in 1 until n) {
        val nextMoves = LongArray(10)
        for (j in 0 .. 9) {
            for (jump in jumps[j]) {
                nextMoves[jump] = (moves[j] + nextMoves[jump]) % MODULO
            }
        }
        moves = nextMoves
    }
    return (moves.sum() % MODULO).toInt()
}
//endregion
