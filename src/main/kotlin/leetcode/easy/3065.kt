package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed integer array 'nums', and an integer 'k'.
 *
 * In one operation, you can remove one occurrence of the smallest element of 'nums'.
 *
 * Return the minimum number of operations needed so that all elements of the array are greater than or
 * equal to 'k'.
 */

//endregion

//region Steps to solve

/**
 *To solve this, we can simply count the number of elements in the array that are smaller than 'k'.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    minOperations(nums = intArrayOf(2, 11, 10, 1, 3), k = 10)

    // Output: 0
    minOperations(nums = intArrayOf(1, 1, 2, 4, 9), k = 1)
}

private fun minOperations(nums: IntArray, k: Int): Int {
    return nums.fold(0) { acc, i -> if (i < k) acc + 1 else acc}
}

//endregion
