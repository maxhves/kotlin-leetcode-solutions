package leetcode.medium

import kotlin.math.abs

//region Problem

/**
 * You are given an array of positive integers (arr). Perform some operations (possibly none) on (arr)
 * so that it satisfies these conditions.
 * - The value of the first element in (arr) must be (1).
 * - The absolute difference between any 2 adjacent elements must be less than or equal to (1). In other
 *   words, (abs(arr[i] - arr[i - 1]]) <= 1) for each (i) where (1 <= i < arr.length) (0-indexed).
 *   (abs(x)) is the absolute value of (x).
 *
 * There are two types of operations that you can perform any number of times:
 * - Decrease the value of any element in (arr) to a smaller positive integer.
 * - Rearrange the elements of (arr) to be in any order.
 *
 * Return the maximum possible value of an element in (arr) after performing the operations to satisfy
 * the conditions.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We can only decrease the value of an element, not increase it.
 * - We could sort the array and then check if each item meets the condition.
 * - The start element must be (1) which will dictate the rest of the array.
 *
 * Steps
 * - Sort the (arr) array in-place.
 * - Create a mutable copy of (arr).
 * - Check if (mutableArr)'s first index is equal to (1).
 *   - If it is not equal to 1, set it to be 1 now.
 * - Initialize a (maximumElement) variable set to 1.
 * - Iterate over the array, from index 1:
 *   - Initialize a (previousElement) variable set to (arr[i - 1]).
 *   - Initialize a (currentElement) variable set to (arr[i]).
 *   - Check if (previousElement) and (currentElement) have an absolute difference smaller than or
 *     equal to 1.
 *     - If they do not:
 *       - Check if (currentElement) is greater than (previousElement).
 *         - If yes, then (currentElement) should be set to (previousElement) + 1.
 *         - Otherwise it must remain as it is.
 *     - Set (maximumElement) to the maximum of (maximumElement) and the new (currentElement).
 * - Ultimately return (maximumElement).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    maximumElementAfterDecrementingAndRearranging(arr = intArrayOf(73, 98, 9))

    // Output: 2
    maximumElementAfterDecrementingAndRearranging(arr = intArrayOf(2, 2, 1, 2, 1))

    // Output: 3
    maximumElementAfterDecrementingAndRearranging(arr = intArrayOf(100, 1, 1000))
}

private fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
    arr.sort()
    val mutableArr = arr.toMutableList()

    if (mutableArr[0] != 1) {
        mutableArr[0] = 1
    }

    var maxElement = 1

    for (i in 1 .. mutableArr.lastIndex) {
        val previousElement = mutableArr[i - 1]
        val currentElement = mutableArr[i]

        if (currentElement !in previousElement .. (previousElement + 1)) {
            mutableArr[i] = previousElement + 1
        }

        maxElement = maxOf(maxElement, mutableArr[i])
    }

    return maxElement
}

//endregion
