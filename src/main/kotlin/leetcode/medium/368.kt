package leetcode.medium

//region Problem

/**
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair
 * (answer[i], answer[j]) of elements in this subset satisfies:
 * - answer[i] % answer[j] == 0
 * OR
 * - answer[j] % answer[i] == 0
 *
 * If there are multiple solutions, return any of them.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {

}

private fun largestDivisibleSubset(nums: IntArray): List<Int> {
    val dp = Array<List<Int>>(nums.size) { emptyList() }
    nums.sort()

    dp[nums.lastIndex] = listOf(nums.last())

    var maxIndex = nums.lastIndex
    var maxSize = 1

    for (i in nums.lastIndex - 1 downTo 0) {
        val list = mutableListOf(nums[i])
        var maxJ = -1
        var maxJSize = 0

        for (j in (i + 1)..nums.lastIndex) {
            if (nums[j] % nums[i] == 0) {
                val size = dp[j].size

                if (size > maxJSize) {
                    maxJ = j
                    maxJSize = size
                }
            }
        }

        if (maxJ > 0) {
            list.addAll(dp[maxJ])
        }

        dp[i] = list
        if (list.size > maxSize) {
            maxIndex = i
            maxSize = list.size
        }
    }

    return dp[maxIndex]
}

//endregion
