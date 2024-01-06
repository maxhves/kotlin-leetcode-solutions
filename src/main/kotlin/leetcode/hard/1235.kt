package leetcode.hard

//region Problem

/**
 * We have (n) jobs, where every job is scheduled to be done from (startTime[i]) to (endTime[i])
 * obtaining a profit of (profit[i]).
 *
 * You're given the (startTime), (endTime) and (profit) arrays, return the maximum profit you can take
 * such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time (X) you will be able to start another job that starts at time
 * (X).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We should sort the input arrays, so that we are able to easily find the next interval.
 * - We should then use a recursive approach and for each iteration:
 *   - Check the index is in range.
 *   - Call the recursive function for the next index (regardless of what it is).
 *   - Find the next index that is strictly consecutive to the current index.
 *     - Get the maxOf (dfs(nextIndex)) and (dfs(nextConsecutiveIndex) + profitOfCurrentIndex).
 *   - Return the resulting max profit.
 * - Ultimately return the recursive function.
 */

//endregion

//region Solution

private fun main() {
    // Output: 120
    jobScheduling(
        startTime = intArrayOf(1, 2, 3, 3),
        endTime = intArrayOf(3, 4, 5, 6),
        profit = intArrayOf(50, 10, 40, 70),
    )
}

private fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val intervals = mutableListOf<Triple<Int, Int, Int>>()

    for (i in startTime.indices) {
        intervals.add(Triple(startTime[i], endTime[i], profit[i]))
    }
    intervals.sortBy { it.first }

    val cache = IntArray(intervals.size)

    fun dfs(index: Int): Int {
        if (index == intervals.size) {
            return 0
        }

        if (cache[index] > 0) {
            return cache[index]
        }

        var resultingProfit = 0

        resultingProfit = dfs(index + 1)

        var nextConsecutiveIndex = index + 1
        while (nextConsecutiveIndex < intervals.size) {
            if (intervals[index].second <= intervals[nextConsecutiveIndex].first) {
                break
            }
            nextConsecutiveIndex++
        }

        resultingProfit = maxOf(resultingProfit, intervals[index].third + dfs(nextConsecutiveIndex))

        cache[index] = resultingProfit
        return resultingProfit
    }

    return dfs(0)
}

//endregion
