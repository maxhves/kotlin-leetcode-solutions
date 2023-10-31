package leetcode.easy

//region Problem

/**
 * Given an integer array (nums), move all the even integers at the beginning of the array followed by
 * all the odd integers.
 *
 * Return any array that satisfies this condition.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We could use a bubble sort algorithm to sort the array so that all the odd numbers are in greater
 *    indexes than the even ones.
 *
 * 1. Create a loop; from 0 to the end of (nums).
 * 2. Create an inner loop; from 1 to the end of the array minus (i).
 * 3. Compare the current element (nums[j]) with the previous element:
 *     - If the previous element is odd then it should be swapped with the current element.
 * 4. Finally return the (nums) array as it is sorted in place.
 */

//endregion

//region Solution

private fun main() {
    // Output: [2, 4, 3, 1]
    sortArrayByParity(nums = intArrayOf(3, 1, 2, 4))

    // Output: [0]
    sortArrayByParity(nums = intArrayOf(0))
}

private fun sortArrayByParity(nums: IntArray): IntArray {
    for (i in 0 .. nums.lastIndex) {
        for (j in 1  .. nums.lastIndex - i) {
            val currentElement = nums[j]
            val previousElement = nums[j - 1]

            if (previousElement % 2 != 0 && currentElement % 2 == 0) {
                nums[j] = previousElement
                nums[j - 1] = currentElement
            }
        }
    }

    return nums
}

//endregion
