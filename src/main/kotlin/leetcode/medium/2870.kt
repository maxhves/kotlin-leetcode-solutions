package leetcode.medium

//region Problem

/**
 * You are given a 0-indexed array (nums) consisting of positive integers.
 *
 * There are two types of operations that you can apply on the array any number of times:
 * - Choose two elements with equal values and delete them from the array.
 * - Choose three elements with equal values and delete them from the array.
 *
 * Return the minimum number of operations required to make the array empty of -1 if it is not possible.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - We can keep track of the frequency of each element by storing it in a frequency hash map.
 * - We can then check a few conditions for any given value in the map:
 *   - If it is smaller than 2; we can't make this work; return -1.
 *   - If it is evenly divisible by 3, we can just divide by 3.
 *   - If it divides with a remainder of 1; minus 2, then re-evaluate.
 *   - If it divides with a remainder of 2; divide by 3 then 2.
 * - With each operation we make a count.
 *
 * - A way to slightly optimize is when evaluating the number of occurrences:
 *   - Add the value of (occurrences / 3).
 *   - Then add the value of; if the occurrence is divisible by 3, 0 else 1.
 */

//endregion

//region Solution

private fun main() {
    // Output: 4
    minOperations(
        nums = intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4),
    )
}

private fun minOperations(nums: IntArray): Int {
    val frequencyMap = HashMap<Int, Int>(nums.size)
    var operations = 0

    for (element in nums) {
        frequencyMap[element] = frequencyMap.getOrDefault(element, 0) + 1
    }

    for (value in frequencyMap.values) {
        if (value == 1) {
            return -1
        }

        operations += (value / 3) + (if (value % 3 == 0) 0 else 1)
    }

    return operations
}

//endregion
