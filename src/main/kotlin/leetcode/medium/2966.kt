package leetcode.medium

//region Problem

/**
 * You are given an integer array nums of size n and a positive integer k.
 *
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 * - Each element of nums should be in exactly one array.
 * - The difference between any two elements in one array is less than or equal to k.
 *
 * Return at 2D array containing all the arrays. If it is impossible to satisfy the conditions, return
 * an empty array. And if there are multiple answers, return any of them.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: [[1, 1, 3], [3, 4, 5], [7, 8, 9]]
    divideArray(
        nums = intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1),
        k = 2,
    )

    // Output: [[2,2,2],[2,3,5],[12,12,12],[12,12,12],[13,13,13],[13,13,14],[14,14,15]]
    divideArray(
        nums = intArrayOf(15, 13, 12, 13, 12, 14, 12, 2, 3, 13, 12, 14, 14, 13, 5, 12, 12, 2, 13, 2, 2),
        k = 2,
    )
}

private fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
    if (nums.size % 3 != 0) return emptyArray()

    nums.sort()
    val result = mutableListOf<IntArray>()
    var currentArray = Array(3) { -1 }

    for (num in nums) {
        val firstInCurrent = currentArray[0]
        val secondInCurrent = currentArray[1]

        if (firstInCurrent == -1) {
            currentArray[0] = num
        } else if (secondInCurrent == -1) {
            if (num - firstInCurrent > k) {
                return emptyArray()
            }

            currentArray[1] = num
        } else {
            if (num - firstInCurrent > k || num - secondInCurrent > k) {
                return emptyArray()
            }

            currentArray[2] = num
            result.add(currentArray.toIntArray())
            currentArray = Array(3) { -1 }
        }
    }

    return result.toTypedArray()
}

//endregion
