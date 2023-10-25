package leetcode.hard

//region Problem

/**
 * Given (n) non-negative integers representing an elevation map where the width of each bar is (1), compute
 * how much water it can trap after raining.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - Trapping water requires the two sides encapsulating it to be higher than that in between.
 * - Two pointers.
 *
 * 1. Initialize two pointers; left and right.
 *    - Left will be: 0.
 *    - Right will be: height.lastIndex.
 * 2. Keep track of the maxLeftHeight and maxRightHeight.
 * 3. Run a loop; while left is smaller than right:
 *    - If maxLeftHeight is smaller than the maxRightHeight:
 *      - Increase the left pointers by one.
 *      - Check how much space is available in this position:
 *        - Take the height and minus it with the maxLeftHeight:
 *          - If this value is smaller than 0 then it is 0.
 *          - Add this value to the result (in reality only if it is greater than 0).
 *      - Again increase left if it is the smaller maximum.
 *    - If maxRightHeight is smaller than the maxLeftHeight:
 *      - Do the check with left but for right.
 * 4. Finally return the resulting value.
 */

//endregion

//region Solution

private fun main() {
    // Output: 6
    trap(height = intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))

    // Output: 9
    trap(height = intArrayOf(4, 2, 0, 3, 2, 5))
}

private fun trap(height: IntArray): Int {
    var result = 0
    var left = 0
    var right = height.lastIndex
    var maxLeftHeight = height[left]
    var maxRightHeight = height[right]

    while (left < right) {
        if (maxLeftHeight <= maxRightHeight) {
            val availableSpace = maxLeftHeight - height[left]

            if (availableSpace > 0) {
                result += availableSpace
            }

            maxLeftHeight = maxOf(height[left], maxLeftHeight)
        } else {
            val availableSpace = maxRightHeight - height[right]

            if (availableSpace > 0) {
                result += availableSpace
            }

            maxRightHeight = maxOf(height[right], maxRightHeight)
        }

        if (maxLeftHeight <= maxRightHeight) {
            left++
        } else {
            right--
        }
    }

    return result
}

//endregion
