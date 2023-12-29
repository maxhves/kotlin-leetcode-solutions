package leetcode.hard

//region Problem

/**
 * You want to schedule a list of jobs in (d) days. Jobs are dependent (i.e. To work on the (i th) job,
 * you have to finish all the jobs (j) where (0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of
 * difficulties of each day of the (d) days. The difficulty of a day is the maximum difficulty of a
 * job done on that day.
 *
 * You are given an integer array (jobDifficulty) and an integer (d). The difficulty of the (i th) job
 * is (jobDifficulty[i]).
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return
 * -1.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - If the number of days is greater than the number of jobs, return -1.
 * - We create a recursive solution (dfs()) with the following parameters:
 *   - (index) the "job" we are currently at.
 *   - (daysLeft) how many days we have left to use up.
 *   - (currentMax) the current maximum job difficulty we have reached for this path.
 *   - We have some base cases:
 *     - If (index) is at the last position:
 *       - Return 0 if there are days left, or Int.MAX_VALUE  otherwise.
 *     - If (daysLeft) is less than 0:
 *       - Return Int.MAX_VALUE, we can't consider this path.
 *   - We also need to calculate the maximum value of (currentMax) and the current job difficulty.
 *   - We should now return the minimum value of calls to the (dfs) function:
 *       - One path where we continue completing jobs on this day.
 *       - One path where we stop completing jobs, and move to the next day.
 *         - In this case, we must add the current maximum difficult we have found.
 * - Ultimately, call the (dfs) function with initial values.
 */

//endregion

//region Solution

private fun main() {
    // Output: 7
    minDifficulty(
        jobDifficulty = intArrayOf(6, 5, 4, 3, 2, 1),
        d = 2,
    )
}

private fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    data class CacheKey(
        val index: Int,
        val daysLeft: Int,
        val maxDifficulty: Int,
    )

    val infinite = Int.MAX_VALUE / 2
    val cache = HashMap<CacheKey, Int>()

    if (d > jobDifficulty.size) {
        return -1
    }

    fun dfs(index: Int, daysLeft: Int, maxDifficulty: Int): Int {
        val cacheKey = CacheKey(index, daysLeft, maxDifficulty)

        if (index == jobDifficulty.size) {
            return if (daysLeft == 0) 0 else infinite
        }

        if (daysLeft == 0) {
            return infinite
        }

        if (cacheKey in cache) {
            return cache.getOrDefault(cacheKey, 0)
        }

        val currentMaxDifficulty = maxOf(jobDifficulty[index], maxDifficulty)

        val minimumPath = minOf(
            dfs(index + 1, daysLeft, currentMaxDifficulty),
            dfs(index + 1, daysLeft - 1, -1) + currentMaxDifficulty
        )
        cache[cacheKey] = minimumPath

        return minimumPath
    }

    return dfs(0, d, -1)
}

//endregion
