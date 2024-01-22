package leetcode.easy

import kotlin.math.exp

//region Problem

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
 * due to some error, one of the numbers in s got duplicated to another number in the set, which
 * results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice in the list and the number that is missing and return them in the
 * form of an array.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - An easy way to solve this is to sort the array and then iterate over each item in the array.
 *   As we iterate we can check if the number is repeated, if so then we know which number is missing.
 */

//endregion

//region Solution

private fun main() {
    // Output: [2, 10]
    findErrorNums(nums = intArrayOf(1, 5, 3, 2, 2, 7, 6, 4, 8, 9))

    // Output: [3, 1]
    findErrorNums(nums = intArrayOf(3, 2, 3, 4, 6, 5))

    // Output: [2, 1]
    findErrorNums(nums = intArrayOf(2, 2))

    // Output: [2, 3]
    findErrorNums(nums = intArrayOf(1, 2, 2, 4))
}

private fun findErrorNums(nums: IntArray): IntArray {
    nums.sort()
    val expectedNumbers = HashSet<Int>(nums.size)

    for (i in nums.indices) {
        expectedNumbers.add(i + 1)
    }

    var previousElement = 0
    var repeatedElement = 0
    for (i in nums) {
        if (i == previousElement) {
            repeatedElement = i
        }

        if (i in expectedNumbers) {
            expectedNumbers.remove(i)
        }

        previousElement = i
    }

    return intArrayOf(repeatedElement, expectedNumbers.first())
}

//endregion
