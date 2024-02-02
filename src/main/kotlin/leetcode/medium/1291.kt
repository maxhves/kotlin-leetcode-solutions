package leetcode.medium

//region Problem

/**
 * An integer has sequential digits if and only if each digit in the number is one more than the previous
 * digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: [123, 234]
    sequentialDigits(low = 100, high = 300)
}

private fun sequentialDigits(low: Int, high: Int): List<Int> {
    val possibleDigits = setOf(
        12,
        23,
        34,
        45,
        56,
        67,
        78,
        89,
        123,
        234,
        345,
        456,
        567,
        678,
        789,
        1234,
        2345,
        3456,
        4567,
        5678,
        6789,
        12345,
        23456,
        34567,
        45678,
        56789,
        123456,
        234567,
        345678,
        456789,
        1234567,
        2345678,
        3456789,
        12345678,
        23456789,
        123456789,
    )
    return possibleDigits.filter { item -> item in low..high }
}

//endregion
