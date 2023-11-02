package leetcode.easy

//region Problem

/**
 * The next greater element of some element (x) in an array is the first greater element that is to the
 * right of (x) in the same array.
 *
 * You are given two distinct 0-indexed integer arrays (nums1) and (nums2), where (nums1) is a subset of
 * (nums2).
 *
 * For each (0 <= i <= nums1.length), find the index (j) such that (nums1[i] == nums2[j]) and determine the
 * next greater element of (nums2[j]) in (nums2). If there is no next greater element, then the answer for
 * this query is (-1).
 *
 * Return an array (ans) of length (nums1.length) such that (ans[i]) is the next greater element as described
 * above.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to find the next greater element to the one in the original array (in its original sort too).
 *
 * 1. Initialise the answer array with a length of (nums1.length).
 * 2. Iterate over the (nums1) array.
 * 3. Iterate over the (nums2) array.
 * 4. For each element in (nums2):
 *     - Check if it is equal to (i).
 *     - If it is equal flag that we have found it.
 *     - When we see an element that is greater than, add it to our answer array.
 *     - If no element is found, lastly add -1 to the arry instead.
 * 5. Return the answer array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [-1, 3, -1]
    nextGreaterElement(
        nums1 = intArrayOf(4, 1, 2),
        nums2 = intArrayOf(1, 3, 4, 2),
    )

    // Output: [3, -1]
    nextGreaterElement(
        nums1 = intArrayOf(2, 4),
        nums2 = intArrayOf(1, 2, 3, 4),
    )
}

private fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val answer = IntArray(nums1.size)

    for (i in nums1.indices) {
        var elementFound = false
        var greaterElement = -1

        for (j in nums2.indices) {
            if (nums1[i] == nums2[j]) {
                elementFound = true
            }

            if (elementFound  && nums2[j] > nums1[i]) {
                greaterElement = nums2[j]
                break
            }
        }

        answer[i] = greaterElement
    }

    return answer
}

//endregion
