package leetcode.medium

//region Problem

/**
 * Given an integer array arr, partition the array into (contiguous) sub-arrays of length at most k.
 * After partitioning, each sub-array has their values changed to become the maximum value of that
 * sub-array.
 *
 * Return the largest sum of the given array after partitioning.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We should partition the array into sizes of at MOST k.
 * - Then we take the largest element in the sub-array and set all other elements to that largest
 *   element.
 * - We sum up all sub-arrays.
 * - We can solve this using dynamic programming.
 */

//endregion

//region Solution

private fun main() {

}

private fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val n = arr.size
    val dp = IntArray(n)

    for (i in arr.indices) {
        var currentMax = 0

        for (j in 1..k) {
            if (i - j + 1 < 0) {
                break
            }
            currentMax = maxOf(currentMax, arr[i - j + 1])
            val previousSum = if (i >= j) dp[i - j] else 0
            dp[i] = maxOf(dp[i], previousSum + currentMax * j)
        }
    }

    return dp[n - 1]
}

//endregion
