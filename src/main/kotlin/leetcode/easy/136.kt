package leetcode.easy

//region Problem

/**
 * Given a non-empty array of integers (nums), every element appears twice except for one. Find that single
 * one.
 *
 * YOu must implement a solution with a linear runtime complexity and only use constant extra space.
 */

//endregion

//region Steps to solve

/**
 * Logical, but not constant space complexity.
 * 1. Create a Set<Int>.
 * 2. Iterate over the (nums) array.
 * 3. For each element:
 *     - Check if the item exists in the set.
 *     - If it exists, remove it.
 * 4. If we reach this point then we return the first item in the set.
 *
 * Constant space complexity.
 * 1. Iterate over the (nums) array.
 * 2. Using the bitwise operator (xor) xor each number in the array.
 * 3. We will be left with the number that wasn't used twice.
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    singleNumber(nums = intArrayOf(2, 2, 1))

    // Output: 4
    singleNumber(nums = intArrayOf(4, 1, 2, 1, 2))

    // Output: 1
    singleNumber(nums = intArrayOf(1))
}

private fun singleNumber(nums: IntArray): Int {
    val numSet = mutableSetOf<Int>()

    for (num in nums) {
        if (numSet.contains(num)) {
            numSet.remove(num)
        } else {
            numSet.add(num)
        }
    }

    return numSet.first()
}

private fun singleNumberConstantSpace(nums: IntArray): Int {
    var result = 0

    for (num in nums) {
        result = result xor num
    }

    return result
}

//endregion
