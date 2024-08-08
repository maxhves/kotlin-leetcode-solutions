package leetcode.medium

//region Problem

/**
 * You are given a 0-indexed integer array 'nums' and an integer 'pivot'. Rearrange 'nums' such that the following
 * conditions are satisfied:
 * - Every element less than 'pivot' appears before every element greater than 'pivot'.
 * - Every element equal to 'pivot' appears in between the elements less than and greater than 'pivot'.
 * - The relative order of the elements less than 'pivot' and the elements greater than 'pivot' is maintained.
 *   - More formally, consider every 'Pi', 'Pj' where 'Pi' is the new position of the 'ith' element and 'Pj' is the
 *     new position of the 'jth' element. For elements less than 'pivot', if 'i < j' and 'nums[i] < pivot' and
 *     'nums[j] < pivot', then 'pi < pj'. Similarly for elements greater than 'pivot', if 'i < j' and 'nums[i] > pivot'
 *     and 'nums[j] > pivot', then 'pi < pj'.
 */

//endregion

//region Steps to solve

/**
 * - Iterate over the 'nums' array.
 * - If the value at the current index is smaller than pivot, add it to an array.
 * - If the value at the current index is greater than pivot, add it to another array.
 * - If the value at the current index is equal to pivot, add it to a final array.
 * - Return a combined array as the answer.
 */

//endregion

//region Solution

private fun main() {
    // Output: [9, 5, 3, 10, 10, 12, 14]
    pivotArray(nums = intArrayOf(9, 12, 5, 10, 14, 3, 10), pivot = 10)

    // Output: [-3, 2, 4, 3]
    pivotArray(nums = intArrayOf(-3, 4, 3, 2), pivot = 2)
}

private fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val beforePivotElements = ArrayDeque<Int>()
    val afterPivotElements = ArrayDeque<Int>()
    val equalPivotElements = ArrayDeque<Int>()

    for (i in nums.indices) {
        val currentElement = nums[i]

        when {
            currentElement < pivot -> beforePivotElements.addLast(currentElement)
            currentElement > pivot -> afterPivotElements.addLast(currentElement)
            else -> equalPivotElements.addLast(currentElement)
        }
    }

    return beforePivotElements.toIntArray() + equalPivotElements.toIntArray() + afterPivotElements.toIntArray()
}

//endregion
