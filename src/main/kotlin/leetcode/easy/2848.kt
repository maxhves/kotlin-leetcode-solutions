package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed 2D integer array (nums) representing the coordinates of the cars parking on
 * a number line. For any index (i), (nums[i] = [start i, end i]) where (start i) is the starting point of
 * the (ith) car and (end i) is the ending point of the (ith) car.
 *
 * Return the number of integer points on the line that are covered with any part of a car.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - Cars can overlap, therefore cannot straight up calculate the difference for each start/end.
 *
 * 1. Iterate of the array of (nums).
 * 2. For each (num):
 *    - Iterate from (num[0]) start to (num[1]) end.
 *    - For each element:
 *      - Add this element to a HashSet.
 * 3. Return how many items the HashSet is holding.
 */

//endregion

//region Solution

private fun main() {
    // Output: 7
    numberOfPoints(
        nums = listOf(
            listOf(3, 6),
            listOf(1, 5),
            listOf(4, 7),
        )
    )

    // Output: 7
    numberOfPoints(
        nums = listOf(
            listOf(1, 3),
            listOf(5, 8),
        )
    )
}

private fun numberOfPoints(nums: List<List<Int>>): Int {
    val coveredPoints = HashSet<Int>()

    for (num in nums) {
        val start = num[0]
        val end = num[1]

        for (i in start .. end) {
            coveredPoints.add(i)
        }
    }

    return coveredPoints.size
}

//endregion
