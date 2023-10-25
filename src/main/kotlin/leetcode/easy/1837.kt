package leetcode.easy

//region Problem

/**
 * Given an integer (n) (in base 10) and a base (k), return the sum of the digits in (n) after converting
 * (n) from base (10) to base (k).
 *
 * After converting, each digit should be interpreted as a base (10) number, and the sum should be
 * returned in base (10).
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - To convert from base-10 to base-k we should:
 *   - Divide the number by k and collect the remainders.
 *   - Divide the new number by k and collect the remainders.
 *   - Repeat until the end.
 *
 * 1. Take our original number (n).
 * 2. Divide by (k), push number into result integer.
 * 3. With the remainder, repeat step 2.
 * 4. Return result.
 */

//endregion

//region Solution

private fun main() {
    // Output: 9
    sumBase(n = 34, k = 6)

    // Output: 1
    sumBase(n = 10, k = 10)
}

private fun sumBase(n: Int, k: Int): Int {
    var result = 0
    var temp = n

    while (temp != 0) {
        result += temp % k
        temp /= k
    }

    return result
}

//endregion
