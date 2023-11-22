package leetcode.medium

import java.util.*

//region Problem

/**
 * Given a 2D integer array (nums), return all elements of (nums) in diagonal order as shown in the below
 * images.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Numbers with equal sums of row and column indexes belong to the same diagonal.
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 4, 2, 7, 5, 3, 8, 6, 9]
    findDiagonalOrder(
        nums = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
        )
    )
}

private fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
    val diagonalMap = TreeMap<Int, MutableList<Int>>()

    for (i in nums.lastIndex downTo 0) {
        for (j in nums[i].indices) {
            val sum = i + j
            val value = nums[i][j]

            val items = diagonalMap.getOrDefault(sum, mutableListOf())
            items.add(value)
            diagonalMap[sum] = items
        }
    }

    val answer = mutableListOf<Int>()
    for (items in diagonalMap.values) {
        answer.addAll(items)
    }

    return answer.toIntArray()
}

//endregion
