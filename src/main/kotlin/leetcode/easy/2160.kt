package leetcode.easy

//region Problem

/**
 * You are given a positive integer `num` consisting of exactly four digits. Split `num` into two new
 * integers `new1` and `new2` by using the digits foun in `num`. Leading zeros are allowed in `new1` and
 * `new2` and all the digits found in `num` must be used.
 *
 * - For example, given `num = 2932` you have the following digits: two `2`'s, one `9` and one `3`.
 *   Some of the possible pairs `[new1, new2]` are `[22, 93]`, `[23, 92]`, `[223, 9]` and `[2, 329]`.
 *
 *   Return the minimum possible sum of `new1` and `new2`
 */

//endregion

//region Test cases

/**
 * Input: num = 2932
 * Output: 52
 *
 * Input: num = 4009
 * Output: 13
 */

//endregion

//region Solution

private fun main() {
    minimumSum(num = 2932)
    minimumSum(num = 4009)
}

private fun minimumSum(num: Int): Int {
    var tempNum = num
    val digits = arrayListOf<Int>()

    while (tempNum > 0) {
        digits.add(tempNum % 10)
        tempNum /= 10
    }
    digits.sort()

    val first = "${digits[0]}${digits[2]}".toInt()
    val second = "${digits[1]}${digits[3]}".toInt()

    println("Minimum sum: ${first + second}")
    return first + second
}

//endregion