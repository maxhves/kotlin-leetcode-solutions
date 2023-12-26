package leetcode.medium

import kotlin.math.min

//region Problem

/**
 * You have (n) dice, and each die has (k) faces numbered from (1) to (k).
 *
 * Given three integers (n), (k), and (target) return the number of possible ways (out of the (k^n)
 * total ways) to roll the dice, so the sum of the face-up numbers equal (target). Since the answer
 * may be too large, return it modulo (10^9 + 7).
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    numRollsToTarget(
        n = 2,
        k = 6,
        target = 7,
    )

    // Output: 222616187
    numRollsToTarget(
        n = 30,
        k = 30,
        target = 500,
    )
}

private fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val modulo = 1_000_000_007
    val cache = Array(target + 1) { LongArray(n + 1) { -1 } }

    fun dfs(throwsRemaining: Int, targetRemaining: Int): Long {
        if (throwsRemaining == 1) {
            return if (targetRemaining in 1..k) 1 else 0
        }

        if (cache[targetRemaining][throwsRemaining] != -1L) {
            return cache[targetRemaining][throwsRemaining]
        }

        var numberOfWays = 0L

        for (i in 1..min(k, targetRemaining)) {
            numberOfWays += dfs(throwsRemaining - 1, targetRemaining - i) % modulo
        }

        cache[targetRemaining][throwsRemaining] = numberOfWays % modulo
        return cache[targetRemaining][throwsRemaining]
    }

    return dfs(n, target).toInt()
}

//endregion
