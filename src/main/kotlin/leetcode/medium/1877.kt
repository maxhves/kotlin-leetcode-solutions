package leetcode.medium

//region Problem

/**
 * The pair sum of a pair (a, b) is equal to (a + b). The maximum pair sum is the largest pair sum
 * in the list of pairs.
 * - For example, if we have pairs (1, 5), (2, 3) and (4, 4) the maximum pair sum would be
 *   (max(1 + 5, 2 + 3, 4 + 4) = max(6, 5, 8) = 8).
 *
 * Given an array (nums) of even length (n), pair up the elements of (nums) into (n / 2) pairs such that:
 * - Each element of (nums) is exactly one pair, and
 * - The maximum pair sum is minimized.
 *
 * Return the minimized maximum paid sum after optimally pairing up the elements.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - The minimized pairs means the smallest pairing we can make.
 * - We then need to take the maximum of those small pairs.
 *
 * Steps
 * - Sort (nums) in-place.
 * - Initialize an Int variable (numPairMax) set to 0.
 * - Create a for loop, from 0 to (nums) last index / 2:
 *   - Get the element at (nums[i]).
 *   - Get the element at (nums[nums.lastIndex - i]).
 *   - Take the sum of these two elements.
 *   - If it is greater than (numPairMax) then set (numPairMax) to this sum value.
 * - Return (numPairMax).
 */

//endregion

//region Solution

private fun main() {
    // Output 7
    minPairSum(nums = intArrayOf(3, 5, 2, 3))
}

private fun minPairSum(nums: IntArray): Int {
    nums.sort()
    var numPairMax = 0

    for (i in 0 .. (nums.lastIndex / 2)) {
        val left = nums[i]
        val right = nums[nums.lastIndex - i]

        numPairMax = maxOf(numPairMax, (left + right))
    }

    return numPairMax
}

//endregion
