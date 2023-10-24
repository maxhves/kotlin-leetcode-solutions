package leetcode.easy

//region Problem

/**
 * Given an integer (n), return any containing (n) unique integers such that they add up to 0.
 */

//endregion

//region Steps to solve

/**
 * 1. If the number is even:
 *    - Take the size of (n) and fill an array from the negative of (n / 2) to positive (n / 2).
 * 2. If the number is even:
 *    - Take the size of (n) and fill an array from the negative of (n / 2) to positive (n / 2).
 *    - Insert 0 into the middle of the array.
 * 3. Return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [-2, -1, 1, 2]
    sumZero(n = 4)

    // Output: [-7, -1, 1, 3, 4]
    sumZero(n = 5)

    // Output: [-1, 0, 1]
    sumZero(n = 3)

    // Output: [0]
    sumZero(n = 1)
}

private fun sumZero(n: Int): IntArray {
    val result = mutableListOf<Int>()
    val bound = (n / 2)

    for (i in (0 - bound) .. bound) {
        if (n % 2 == 0 && i == 0) {
            // Skip
        } else {
            result.add(i)
        }
    }

    return result.toIntArray()
}

//endregion
