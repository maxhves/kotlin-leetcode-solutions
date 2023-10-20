package leetcode.easy

//region Problem

/**
 * Given an integer (n), return an array (ans) of length (n + 1) such that for each (i) (0 <= i <= n),
 * (ans[i]) is the number of 1s in the binary representation of (i).
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate from 0 up to n.
 * 2. For each (i) place the bit count into an array.
 * 3. Return the int array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0, 1, 1]
    countBits(n = 2)

    // Output: [0,1,1,2,1,2]
    countBits(n = 5)
}

private fun countBits(n: Int): IntArray {
    val answer = IntArray(n)

    for (i in 0 .. n + 1) {
        answer[i] = i.countOneBits()
    }

    return answer
}

//endregion
