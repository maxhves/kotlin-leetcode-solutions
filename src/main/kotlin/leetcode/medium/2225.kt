package leetcode.medium

//region Problem

/**
 * You are given an integer array (matches) where (matches[i] = [winner i, loser i]) indicates that
 * the player (winner i) defeated player (loser i) in a match.
 *
 * Return a list (answer) of size 2 where:
 * - (answer[0]) is a list of all players that have not lost any matches.
 * - (answer[1]) is a list of all players that have lost exactly one match.
 *
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 * - You should only consider players that have played at least one match.
 * - The testcases will be generated such that no two matches will have the same outcome.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We need to keep track of players who have never lost.
 * - We also need to keep track of players who have lost 1 match.
 * - We can keep a Set for (neverLost) players.
 * - We can keep another Set for (lostOnce) players.
 * - Iterate over each (match) in the (matches) array:
 *   - (match[0]) = (winner).
 *   - (match[1]) = (loser).
 *   - If (winner) does not exist in (neverLost); add it.
 *   - If (winner) exists in (neverLost); remove it:
 *     - If (winner) exists in (lostOnce); remove it.
 *     - If (winner) does not exist in (lostOnce); add it.
 * - Ultimately, return the two sets in a list.
 */

//endregion

//region Solution

private fun main() {
    // Output: [[1,2,10],[4,5,7,8]]
    findWinners(
        matches = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 6),
            intArrayOf(5, 6),
            intArrayOf(5, 7),
            intArrayOf(4, 5),
            intArrayOf(4, 8),
            intArrayOf(4, 9),
            intArrayOf(10, 4),
            intArrayOf(10, 9),
        )
    )
}

private fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val neverLostPlayers = mutableSetOf<Int>()
    val lostOncePlayers = mutableSetOf<Int>()
    val lostMoreThanOncePlayers = mutableSetOf<Int>()

    for (match in matches) {
        val winner = match[0]
        val loser = match[1]

        if (winner !in neverLostPlayers && winner !in lostOncePlayers && winner !in lostMoreThanOncePlayers) {
            neverLostPlayers.add(winner)
        }

        if (loser in neverLostPlayers) {
            neverLostPlayers.remove(loser)
        }

        if (loser in lostOncePlayers) {
            lostOncePlayers.remove(loser)
            lostMoreThanOncePlayers.add(loser)
        } else if (loser !in lostMoreThanOncePlayers) {
            lostOncePlayers.add(loser)
        }
    }

    return listOf(neverLostPlayers.toList().sorted(), lostOncePlayers.toList().sorted())
}

//endregion
