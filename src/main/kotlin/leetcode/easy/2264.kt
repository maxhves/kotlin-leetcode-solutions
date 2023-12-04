package leetcode.easy

//region Problem

/**
 * You are given a string (num) representing a large integer. An integer is good if it meets the following
 * conditions:
 * - It is a substring of (num) with length (3).
 * - It consists of only one unique digit.
 *
 * Return the maximum good integer as a string or an empty string ("") if no such integer exists.
 */

//endregion

//region Steps to solve

/**
 *
 */

//endregion

//region Solution

private fun main() {
    // Output: "777".
    largestGoodInteger(num = "6777133339")
}

private fun largestGoodInteger(num: String): String {
    var right = 2
    var maxGoodWord = ""

    while (right <= num.lastIndex) {
        if (num[right - 2] == num[right - 1] && num[right - 2] == num[right]) {
            maxGoodWord = maxOf(maxGoodWord, "${num[right - 2]}${num[right - 1]}${num[right]}")
        }
        right ++
    }

    return maxGoodWord
}

//endregion
