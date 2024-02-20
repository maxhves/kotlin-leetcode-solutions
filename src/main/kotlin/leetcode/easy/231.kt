package leetcode.easy

//region Problem

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two if there exists an integer x such that n == 2^x
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    isPowerOfTwo(n = 1)

    // Output: true
    isPowerOfTwo(n = 16)
}

private fun isPowerOfTwo(n: Int): Boolean {
    return if (n <= 0) false else n and n - 1 == 0
}

//endregion
