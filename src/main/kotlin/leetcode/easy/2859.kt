package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed integer array `nums` and an integer `k`.
 * Return an integer that denotes the sum of elements in `nums` whose corresponding indices have exactly
 * `k` set bits in their binary representation.
 *
 * The set bits in an integer are the `1`'s present when it is written in binary.
 * - For example, the binary representation of `21` is `10101`, which has `3` set bits.
 */

//endregion

//region Test cases

/**
 * Input: nums = [5,10,1,5,2], k = 1
 * Output: 13
 *
 * Input: nums = [4,3,2,1], k = 2
 * Output: 1
 */

//endregion

//region Solution

fun main() {
    sumIndicesWithKSetBits(nums = listOf(5, 10, 1, 5, 2), k = 1)
    sumIndicesWithKSetBits(nums = listOf(4, 3, 2, 1), k = 2)
}

fun sumIndicesWithKSetBits(nums: List<Int>, k: Int): Int {
    var setBitIndexSum = 0

    for (i in nums.indices) {
        if (i.countOneBits() == k) {
            setBitIndexSum += nums[i]
        }
    }

    println("Set bit index count: $setBitIndexSum")
    return setBitIndexSum
}

//endregion