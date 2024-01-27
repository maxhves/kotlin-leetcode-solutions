package leetcode.hard

//region Problem

/**
 * For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length
 * and nums[i] > nums[j].
 *
 * Given two integers n and k, return the number of different arrays consist of numbers from 1 to n
 * such that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 10^9 + 7.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - n: a set of numbers from 1 to n.
 * - k: the number of inverse pairs we need to find.
 * - An inverse pair is a pair of numbers where the first number is greater than the second.
 *   - A sorted array will produce 0 sets of inverse pairs, since all elements are greater than the
 *     previous element in the array.
 *
 */

//endregion

//region Solution

private fun main() {
    // Output: 1
    kInversePairs(n = 3, k = 0)

    // Output: 2
    kInversePairs(n = 3, k = 1)
}

private fun kInversePairs(n: Int, k: Int): Int {
    val modulo = 1_000_000_007
    var previous = Array(k + 1) { 0 }
    previous[0] = 1

    for (i in 1..n) {
        val current = Array(k + 1) { 0 }
        var total = 0

        for (j in 0..k) {
            if (j >= i) {
                total = (total - previous[j - i] + modulo) % modulo
            }

            total = (total + previous[j]) % modulo
            current[j] = total
        }
        previous = current
    }

    return previous[k]
}

//endregion
