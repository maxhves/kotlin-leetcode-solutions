package leetcode.medium

import kotlin.math.abs

//region Problem

/**
 * A sequence of number is called arithmetic if it consists of at least two elements, and the difference
 * between every two consecutive elements is the same. More formally, a sequence (s) is arithmetic if and
 * only if (s[i + 1] - s[i] == s[1] - s[0]) for all valid (i).
 *
 * For example, these are arithmetic sequences:
 * > 1, 3, 5, 7, 9
 * > 7, 7, 7, 7, 7
 * > 3, -1, -5, -9
 *
 * The following sequence is not arithmetic:
 * > 1, 1, 2, 5, 7
 *
 * You are given an array of (n) integers, (nums), and two arrays of (m) integers each, (l) and (r),
 * representing the (m) range queries, where the (ith) query in the range ([l[i], r[i]]). All the arrays
 * are 0-indexed.
 *
 * Return a list of (boolean) elements (answer), where (answer[i]) is (true) if the subarray
 * ([nums[l[i]], nums[l[i]+1], ..., nums[ri]]) can be rearranged to form an arithmetic sequence and
 * (false) otherwise.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - Array (l) denotes the start index of the range to query.
 * - Array (r) denotes the end index of the range to query.
 * - We are to take a range using the above and check if the sequence in the range can be at all
 *   rearranged to make an arithmetic sequence.
 *
 * Steps
 * - Initialize an ArrayList<Boolean> (answer).
 * - Create a loop from 0 upTo (l)'s last index, and for each:
 *   - Initialize an IntArray (currentRange).
 *   - Create an inner loop from (l[i]) to (r[i]), and for each:
 *     - Add each element to (currentRange).
 *   - Sort (currentRange).
 *   - Initialize an Int (desiredDifference) to (currentRange[0]) - (currentRange[1]).
 *   - Iterate over (currentRange) from 0 until (currentRange.lastIndex):
 *     - Initialize an Int (current) set to (currentRange[i]).
 *     - Initialize an Int (next) set to (currentRange[i + 1]).
 *     - If (current - next) is equal to (desiredDifferenct); continue.
 *     - Else; break; add (false) to (answer).
 *     - Add (true) to answer.
 * - Ultimately return (answer).
 */

//endregion

//region Solution

private fun main() {
    // Output: [true, false, true]
    checkArithmeticSubarrays(
        nums = intArrayOf(4, 6, 5, 9, 3, 7),
        l = intArrayOf(0, 0, 2),
        r = intArrayOf(2, 3, 5),
    )
}

private fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
    val answer = mutableListOf<Boolean>()

    for (i in l.indices) {
        val queryRange = nums.copyOfRange(l[i], r[i] + 1)
        queryRange.sort()

        val difference = abs(queryRange[1] - queryRange[0])
        var isArithmetic = true

        for (j in 0 until queryRange.lastIndex) {
            if (abs(queryRange[j] - queryRange[j + 1]) != difference) {
                isArithmetic = false
                break
            }
        }
        answer.add(isArithmetic)
    }

    return answer
}

//endregion
