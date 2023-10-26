package leetcode.medium

//region Problem

/**
 * You are given an integer array (pref) of size (n). Find and return the array (arr) of size (n) that
 * satisfies:
 *  - (pref[i] = arr[0] XOR arr[1] XOR ... XOR arr[i]).
 *
 *  It can be proven that the answer is unique.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - The start index will always be the same.
 * - It appears that (i) XOR (i + 1) gives us the answer to each index in (arr).
 *
 * 1. Iterate over the (pref) array.
 * 2. For each index the array, after 0:
 *    - Take (i) XOR (i + 1).
 *    - Insert this into the answer array.
 * 3. Return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [5, 7, 2, 3, 2]
    findArray(pref = intArrayOf(5, 2, 0, 3, 1))

    // Output: [13]
    findArray(pref = intArrayOf(13))
}

private fun findArray(pref: IntArray): IntArray {
    val answer = IntArray(pref.size)
    answer[0] = pref[0]

    for (i in 0 until pref.size - 1) {
        answer[i + 1] = pref[i] xor pref[i + 1]
    }

    return answer
}

//endregion
