package leetcode.medium

//region Problem

/**
 * You are given an array (nums) that consists of non-negative integers. Let us define (rev(x)) as the
 * reverse of the non-negative integer (x). For example, (rev(123) = 321). and (rev(120) = 21). A pair
 * (i, j) is nice if it satisfies all the following conditions:
 * - (0 <= i < j < nums.length)
 * - (nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]))
 *
 * Return the number of nice pairs of indices. Since that number can be too large return it in modulo
 * (10^9 + 7).
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - (i) is to be greater than 0 and (j) is to be strictly greater than (i).
 * - The element at (nums[i]) plus the reverse at element (nums[j]) should be equal to the element at
 *   (nums[j]) plus the reverse at element (nums[i]).
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    countNicePairs(nums = intArrayOf(432835222, 112141211, 5408045, 456281503, 283322436, 414281561, 37773, 286505682))

    // Output: 4
    countNicePairs(nums = intArrayOf(13, 10, 35, 24, 76))

    // Output: 2
    countNicePairs(nums = intArrayOf(42, 11, 1, 97))
}

private fun countNicePairs(nums: IntArray): Int {
    val modulo = 1_000_000_007
    var pairs: Long = 0

    val pairRevSums = HashMap<Int, Int>(nums.size)

    for (i in nums.indices) {
        val result = nums[i] - (nums[i].toString().reversed().toInt())
        pairRevSums[result] = pairRevSums.getOrDefault(result, 0) + 1
    }

    for (frequency in pairRevSums.values) {
        pairs += ((frequency.toLong() * (frequency - 1)) / 2)
    }

    return (pairs % modulo).toInt()
}

//endregion
