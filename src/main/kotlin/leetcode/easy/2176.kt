package leetcode.easy

//region Problem

/**
 * Given a 0-indexed integer array nums, of length n and an integer k, return the number of pairs (i, j)
 * where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the integer array with i.
 * 2. Iterate over the integer array with j for i.
 * 3. If i and j match:
 *    - Check if they are also divisible by k when multiplied together:
 *      - If yes, increment pair count.
 *      - If no, move on.
 * 4. Return the count of pairs.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    countPairs(nums = intArrayOf(3, 1, 2, 2, 2, 1, 3), k = 2)

    // Output: 0
    countPairs(nums = intArrayOf(1, 2, 3, 4), k = 1)
}

private fun countPairs(nums: IntArray, k: Int): Int {
    var pairs = 0

    for (i in 0 .. nums.lastIndex - 1) {
        for (j in i + 1 .. nums.lastIndex) {
            if (nums[i] == nums[j]) {
                if ((i * j) % k == 0) {
                    pairs++
                }
            }
        }
    }

    return pairs
}

//endregion