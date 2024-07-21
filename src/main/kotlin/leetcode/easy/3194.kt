package leetcode.easy

//region Problem

/**
 * You have an array of floating point numbers 'averages' which is initially empty. You are given an array 'nums' of
 * 'n' integers where 'n' is even.
 *
 * You repeat the following procedure 'n / 2' times:
 *  - Remove the smallest element, 'minElement' and the largest element 'maxElement', from 'nums'.
 *  - Add '(minElement + maxElement) / 2' to 'averages'.
 *
 * Return the minimum element in 'averages'.
 */

//endregion

//region Steps to solve

/**
 * Sort the array.
 * Loop for 'n / 2' times.
 * Repeat the routine:
 * - Add '(minElement + maxElement) / 2' to 'averages'.
 * - 'averages' can become a simply variable that stores the current minimum value, there is no need for an array.
 * - If there was a need for an array, we might use a 'SortedSet'.
 */

//endregion

//region Solution

private fun main() {
    // Output: 5.5
    minimumAverage(nums = intArrayOf(7, 8, 3, 4, 15, 13, 4, 1))

    // Output: 5.5
    minimumAverage(nums = intArrayOf(1, 9, 8, 3, 10, 5))
}

private fun minimumAverage(nums: IntArray): Double {
    nums.sort()
    val numsMutable = nums.toMutableList()
    var minimumAverage: Double = Int.MAX_VALUE.toDouble()

    for (i in 1..(nums.size / 2)) {
        val minElement = numsMutable.removeFirst().toDouble()
        val maxElement = numsMutable.removeLast().toDouble()

        minimumAverage = minOf(minimumAverage, (minElement + maxElement) / 2)
    }

    return minimumAverage
}

//endregion
