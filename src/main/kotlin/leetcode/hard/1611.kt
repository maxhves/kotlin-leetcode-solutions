package leetcode.hard

//region Problem

/**
 * Given an integer (n), you must transform it into (0) using the following operations any number of times.
 * - Change the rightmost (0th) bit in the binary representation of (n).
 * - Change the (ith) bit in the binary representation of (n) if the ((i - 1)th) bit is set to (1) and the
 *   ((i - 2)th) through (0th) bits are set to (0).
 *
 * Return the minimum number of operations to transform (n) into (0).
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {

}

private fun minimumOneBitOperations(n: Int): Int {
    if (n == 0) {
        return 0
    }

    var k = 0
    var curr = 1
    while (curr * 2 <= n) {
        curr *= 2
        k++
    }

    return (1 shl k + 1) - 1 - minimumOneBitOperations(n xor curr)
}

//endregion
