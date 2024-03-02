package leetcode.easy

import java.util.PriorityQueue

//region Problem

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each
 * number sorted in non-decreasing order.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Iterate over the array, square each number
 * - Sort the array
 */

//endregion

//region Solution

private fun main() {

}

private fun sortedSquares(nums: IntArray): IntArray {
    val result = mutableListOf<Int>()

    for (num in nums) {
        result.add(num * num)
    }

    return result.sorted().toIntArray()
}

//endregion
