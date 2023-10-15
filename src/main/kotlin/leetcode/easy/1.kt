package leetcode.easy

//region Problem

/**
 * Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that
 * they add up to `target`.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element
 * twice.
 *
 * You can return the answer in any order.
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the nums array.
 * 2. Take the sum of i + (nums.length - i):
 *    - If they sum to target, return the indices.
 *    - Continue until a solution is found.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0,1]
    twoSum(nums = intArrayOf(2, 7, 11, 15), target = 9)

    // Output: [1,2]
    twoSum(nums = intArrayOf(3, 2, 4), target = 6)

    // Output: [0,1]
    twoSum(nums = intArrayOf(3, 3), target = 6)
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val hashMap = HashMap<Int, Int>()

    nums.forEachIndexed { index, num ->
        val compliment = target - num

        if (hashMap.containsKey(compliment)) {
            val entry = hashMap[compliment]!!
            return intArrayOf(index, entry)
        } else {
            hashMap[num] = index
        }
    }

    return intArrayOf()
}

//endregion