package leetcode.easy

//region Problem

/**
 * Write a function that takes the binary representation of an unsigned integer, and return the number
 * of '1' bits it has (also known as the Hamming weight).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Return the one bit count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    hammingWeight(n = 1011)
}

private fun hammingWeight(n: Int): Int {
    return n.countOneBits()
}

//endregion
