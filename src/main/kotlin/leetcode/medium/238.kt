package leetcode.medium

//region Problem

/**
 * Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product
 * of all the elements of `nums` except `nums[i]`.
 *
 * The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in `O(n)` time and without using the division operation.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: [24,12,8,6]
    productExceptSelf(nums = intArrayOf(1, 2, 3, 4))

    // Output: [-1,1,0,-3,3]
    productExceptSelf(nums = intArrayOf(0, 0, 9, 0, 0))
}

private fun productExceptSelf(nums: IntArray): IntArray {
    val answer = IntArray(nums.size)

    var prefix = 1
    for (i in nums.indices) {
        answer[i] = prefix
        prefix *= nums[i]
    }

    var suffix = 1
    for (i in nums.lastIndex downTo 0) {
        answer[i] *= suffix
        suffix *= nums[i]
    }

    return answer
}

//endregion