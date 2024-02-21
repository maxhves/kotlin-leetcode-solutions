package leetcode.medium

//region Problem

/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND
 * of all numbers in this range, inclusive.
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
    rangeBitwiseAnd(left = 5, right = 7)
}

private fun rangeBitwiseAnd(left: Int, right: Int): Int {
    if (left == 0 || right == 0) {
        return 0
    }

    val maskInitial = 0x7FFFFFFF
    var mask = maskInitial

    while ((mask and left) != (mask and right)) {
        mask = mask shl 1
        mask = mask and maskInitial
    }

    return right and mask
}

//endregion
