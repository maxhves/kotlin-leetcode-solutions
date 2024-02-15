package leetcode.medium

//region Problem

/**
 * You are given an array of positive integers nums of length n.
 *
 * A polygon is a closed plane figure that has at least 3 sides. The longest side of a polygon is smaller
 * than the sum of its other sides.
 *
 * Conversely, if you have k (k >= 3) positive real numbers a1, a2, a3 ... ak where a1 <= a2 <= a3 <= ak
 * and a1 + a2 + a3 + ... + ak, then there always exists a polygon with k sides whose lengths are a1,
 * a2, a3 ... ak.
 *
 * The perimeter of a polygon is the sum of lengths of its sides.
 *
 * Return the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if its
 * not possible to create a polygon.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - The longest side of the polygon is never going to be longer than the other two sides.
 */

//endregion

//region Solution

private fun main() {
    // Output: 15
    largestPerimeter(nums = intArrayOf(5, 5, 5))
}

private fun largestPerimeter(nums: IntArray): Long {
    nums.sort()

    var result = -1L
    var total = 0L

    for (num in nums) {
        if (total > num) {
            result = total + num
        }
        total += num
    }

    return result
}

//endregion
