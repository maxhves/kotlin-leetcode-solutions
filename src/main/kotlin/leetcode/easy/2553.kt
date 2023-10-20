package leetcode.easy

//region Problem

/**
 * Given an array of positive integers (nums), return an array (answer) that consists of the digits
 * of each integer in (nums) after separating them in the same order they appear in (nums).
 *
 * To separate the digits of an integer is to get all the digits it has in the same order.
 *  - For example, for the integer (10921), the separation of its digits is [1, 0, 9, 2, 1].
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the (nums) array.
 * 2. For each element we should:
 *    - Convert the element to string and then a char array.
 *    - Convert each char from a digit to an int.
 * 3. Add the items into the answer integer array.
 * 4. Return the answer array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [1,3,2,5,8,3,7,7]
    separateDigits(nums = intArrayOf(13, 25, 83, 77))

    // Output: [7,1,3,9]
    separateDigits(nums = intArrayOf(7, 1, 3, 9))
}

private fun separateDigits(nums: IntArray): IntArray {
    val answer = ArrayList<Int>()

    for (i in nums.lastIndex downTo 0) {
        var element = nums[i]

        while (element > 0) {
            answer.add(element % 10)
            element /= 10
        }
    }

    return answer.reversed().toIntArray()
}

//endregion
