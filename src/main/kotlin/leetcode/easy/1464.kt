package leetcode.easy

//region Problem

/**
 * Given the array of integers (nums), you will choose two different indices (i) and (j) of that array.
 * Return the maximum value of ((nums[i] - 1) * (nums[j] - 1)).
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output 12
    println(maxProduct(nums = intArrayOf(3, 4, 5, 2)))

    // Output: 16
    println(maxProduct(nums = intArrayOf(1, 5, 4, 5)))
}

private fun maxProduct(nums: IntArray): Int {
    var greatestNum = Int.MIN_VALUE
    var secondGreatestNum = Int.MIN_VALUE

    for (num in nums) {
        if (num > greatestNum) {
            secondGreatestNum = greatestNum
            greatestNum = num
        } else if (num > secondGreatestNum) {
            secondGreatestNum = num
        }
    }

    return (greatestNum - 1) * (secondGreatestNum - 1)
}

//endregion
