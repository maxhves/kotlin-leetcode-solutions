package leetcode.easy

//region Problem

/**
 * There are (n) teams numbered from (0) to (n - 1) in a tournament.
 *
 * Given a 0-indexed 2D boolean matrix (grid) of size (n * n). For all (i, j) that (0 <= i, j <= n - 1)
 * and (i != j) team (i) is stronger than (j) if (grid[i][j] == 1), otherwise team (j) is stronger than
 * team (i).
 *
 * Team (a) will be the champion of the tournament if there is no team (b) that is stronger than team (a).
 *
 * Return the team that will be the champion of the tournament.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - We are to find the team that has "won" the most times.
 * - We could iterate over the grid and fold each row.
 * - Store the team that has the highest score so far.
 */

//endregion

//region Solution

private fun main() {
    // Output: 0
    findChampion(
        grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 0),
        ),
    )

    // Output: 1
    findChampion(
        grid = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
        ),
    )
}

private fun findChampion(grid: Array<IntArray>): Int {
    var teamWithHighestScore = Int.MIN_VALUE to Int.MIN_VALUE

    for (i in grid.indices) {
        val row = grid[i]
        val score = row.fold(0) { it, acc -> it + acc }

        if (score > teamWithHighestScore.second) {
            teamWithHighestScore = i to score
        }
    }

    return teamWithHighestScore.first
}

//endregion
