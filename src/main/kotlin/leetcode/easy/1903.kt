package leetcode.easy

//region Problem

/**
 * You are given a string (num), representing a large integer. Return the largest-valued odd integer
 * (as a string) that is a non-empty substring of (num) or an empty string ("") if no odd integer exists.
 *
 * A substring is a contiguous sequence of characters within a string.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    // Output: 5
    largestOddNumber(num = "52")
}

private fun largestOddNumber(num: String): String {
    if (num.isEmpty()) return ""

    for (i in num.indices.reversed()) {
        if (num[i].digitToInt() % 2 != 0) {
            return num.substring(0..i)
        }
    }
    return ""
}

//endregion
