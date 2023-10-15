package leetcode.easy

//region Problem

/**
 * Given an integer array `nums`, return `true` if any value appears at least twice in the array,
 * and return `false` if every element is distinct.
 */

//endregion

//region Steps to solve

/**
 * 1. Create a HashSet<Int>.
 * 2. Iterate over the array of integers:
 *    - If item exists in the hash set, return true.
 *    - If item does not exist, add item to the hash set.
 * 3. If we reach this point, return false.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    containsDuplicate(nums = intArrayOf(1, 2, 3, 1))

    // Output: false
    containsDuplicate(nums = intArrayOf(1, 2, 3, 4))

    // Output: true
    containsDuplicate(nums = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2))
}

private fun containsDuplicate(nums: IntArray): Boolean {
    val hashSet = HashSet<Int>()

    for (num in nums) {
        if (hashSet.contains(num)) {
            return true
        } else {
            hashSet.add(num)
        }
    }

    return false
}

//endregion