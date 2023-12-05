package leetcode.easy

//region Problem

/**
 * You are given an integer (n), the number of teams in a tournament that has strange rules:
 * - If the current number of teams is even, each team gets paired with another team. A total of (n / 2)
 *   matches are played, and (n / 2) teams advance to the next round.
 * - If the current number of teams is odd, one team randomly advances in the tournament, and the rest
 *   gets paired. A total of ((n - 1) / 2) matches are played, and ((n - 1) / 2 + 1) teams advance to the
 *   next round.
 *
 * Return the number of matches played in the tournament until a winner is decided.
 */

//endregion

//region Steps to solve

/**
 *
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    numberOfMatches(n = 7)
}

private fun numberOfMatches(n: Int): Int {
    var numberOfMatches = 0
    var numberOfTeams = n

    while (numberOfTeams > 1) {
        if (numberOfTeams % 2 == 0) {
            val result = numberOfTeams / 2
            numberOfMatches += result
            numberOfTeams = result
        } else {
            val result = (numberOfTeams - 1) / 2
            numberOfMatches += result
            numberOfTeams = result + 1
        }
    }

    return numberOfMatches
}

//endregion
