package leetcode.easy

//region Problem

/**
 * You are given an integer array (nums). The unique elements of an array are the elements that appear
 * exactly once in the array.
 *
 * Return the sum of all the unique characters of (nums).
 */

//endregion

//region Steps to solve

/**
 * 1. Place items in a frequency HashMap.
 * 2. Return the same of each key that has a value of 1.
 *    - This means only get the items that have appeared once in the original array.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    sumOfUnique(nums = intArrayOf(1, 2, 3, 2))

    // Output: 0
    sumOfUnique(nums = intArrayOf(1, 1, 1, 1, 1))
}

private fun sumOfUnique(nums: IntArray): Int {
    val uniqueSet = HashSet<Int>()
    val nonUniqueSet = HashSet<Int>()
    var sum = 0

    for (num in nums) {
        if (nonUniqueSet.contains(num)) {
            continue
        }

        if (uniqueSet.contains(num)) {
            uniqueSet.remove(num)
            nonUniqueSet.add(num)
            sum -= num
        } else {
            uniqueSet.add(num)
            sum += num
        }
    }

    return sum
}

//endregion
