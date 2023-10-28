package leetcode.easy

//region Problem

/**
 * Given three integer arrays (nums1), (nums2) and (nums3), return a distinct array containing all the
 * values that are present in at least two out of the three arrays.
 *
 * You may return the values in any order.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We must find distinct values.
 *  - These values must also appear in at least 2 out of the 3 arrays.
 *
 * 1. Create a HashSet of type integer, this will store our answer.
 * 2. Iterate over the first array:
 *    - For each element:
 *      - Check if the second array contains (i).
 *      - Check if the third array contains (i).
 *      - If any of them contain the element, add the item to our hash set.
 * 3. Iterate over the second array:
 *    - Repeat the process used with the first array.
 * 4. Iterate over the third array:
 *    - Repeat the process used with the first, and second array.
 * 5. Return the result HashSet as a list of integers.
 */

//endregion

//region Solution

private fun main() {
    // Output: [3, 2]
    twoOutOfThree(
        nums1 = intArrayOf(1, 1, 3, 2),
        nums2 = intArrayOf(2, 3),
        nums3 = intArrayOf(3),
    )

    // Output: [2, 3, 1]
    twoOutOfThree(
        nums1 = intArrayOf(3, 1),
        nums2 = intArrayOf(2, 3),
        nums3 = intArrayOf(1, 2),
    )

    // Output: []
    twoOutOfThree(
        nums1 = intArrayOf(1, 2, 2),
        nums2 = intArrayOf(4, 3, 3),
        nums3 = intArrayOf(5),
    )
}

private fun twoOutOfThree(
    nums1: IntArray,
    nums2: IntArray,
    nums3: IntArray,
): List<Int> {
    val resultSet = HashSet<Int>()

    // First array
    for (num in nums1) {
        if (nums2.contains(num)) {
            resultSet.add(num)
        }
        if (nums3.contains(num)) {
            resultSet.add(num)
        }
    }

    // Second array
    for (num in nums2) {
        if (nums1.contains(num)) {
            resultSet.add(num)
        }
        if (nums3.contains(num)) {
            resultSet.add(num)
        }
    }

    // Third array
    for (num in nums3) {
        if (nums1.contains(num)) {
            resultSet.add(num)
        }
        if (nums2.contains(num)) {
            resultSet.add(num)
        }
    }

    return resultSet.toList()
}

//endregion
