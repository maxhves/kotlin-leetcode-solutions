package leetcode.easy

import kotlin.math.abs

//region Problem

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits
 * are different.
 *
 * Given two integers (x) and (y), return the Hamming distance between them.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We could get the bitwise difference between two numbers using (xor).
 *  - We could represent each integer as a binary representation.
 *
 * 1. Get the binary representation for each number.
 * 2. Iterate over the length of the representations.
 * 3. Count the indexes that differ.
 * 4. Return the resulting count.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    hammingDistance(x = 1, y = 4)

    // Output: 1
    hammingDistance(x = 3, y = 1)
}

private fun hammingDistance(x: Int, y: Int): Int {
    var bitDifferenceCount = 0

    val xBin = Integer.toBinaryString(x).padStart(Int.SIZE_BITS, '0').toCharArray()
    val yBin = Integer.toBinaryString(y).padStart(Int.SIZE_BITS, '0').toCharArray()

    for (i in 0 .. xBin.lastIndex) {
        if (xBin[i] != yBin[i]) {
            bitDifferenceCount++
        }
    }

    return bitDifferenceCount
}

//endregion
