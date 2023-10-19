package leetcode.easy

import java.util.Arrays

private fun main(args: Array<String>) {
    differenceOfSum(intArrayOf(1, 15, 6, 3))
}

private fun differenceOfSum(nums: IntArray): Int {
    println(nums.contentToString())
    // Problem
    // Positive integer array *nums*
    // Sum of all elements in *nums*
    // Sum of all the digits that appear in *nums*
    // Return the difference between the two sums

    // Case
    // [1,15,6,3]
    // Element sum is: 25
    // Digit sum is: 16
    // Return difference: (25-16) = 9

    var elementSum: Int = 0
    var digitString: String = ""

    for (num in nums) {
        elementSum += num

        digitString += num
    }

    println(digitString)

    val digitInts = digitString.map { it.toString().toInt() }
    var digitSum: Int = 0

    for (digit in digitInts) {
        digitSum += digit
    }

    val difference = elementSum - digitSum

    println(difference)

    return difference
}