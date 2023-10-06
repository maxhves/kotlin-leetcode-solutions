package leetcode.easy

//region Problem

/**
 * A bit flip of a number `x` is choosing a bit in the binary representation of `x` and flipping it from
 * either `0` to `1` or `1` to `0`.
 *  - For example, for `x = 7` the binary representation is `111` and we may choose any bit (including any
 *    leading zeroes not shown) and flip it. We can flip the first bit from the right to get `110`, flip
 *    the second bit from the right to get `101`, flip the fifth bit from the right (a leading zero) to get
 *    `10111` etc.
 *
 * Given two integers `start` and `goal`, return the minimum number of bit flips to convert `start` to `goal`.
 */

//endregion

//region Test cases

/**
 * Input: start = 10, goal = 7
 * Output: 3
 *
 * Input: start = 3, goal = 4
 * Output: 3
 */

//endregion

//region Steps to solve

/**
 * 1. Convert start and goal into binary representations.
 * 2. Loop over the bits.
 * 3. For each difference in start:
 *    - Flip the bit.
 *    - Count the flip.
 * 4. Return the number of flips.
 */

//endregion

//region Solution

private fun main() {
    println(minBitFlips(start = 10, goal = 7))
    println(minBitFlips(start = 3, goal = 4))
}

private fun minBitFlips(start: Int, goal: Int): Int {
    // Find the binary difference between start/goal
    var result = start xor goal
    var answer = 0

    // Loop until we are done with all bits
    while (result > 0) {
        // Check if the number is odd
        // If odd the last bit will be 1
        if (result % 2 == 1) {
            answer++
        }

        // Shift to the next bit on the left by halving the number
        result /= 2
    }

    return answer
}