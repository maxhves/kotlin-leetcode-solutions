package leetcode.medium

fun main(args: Array<String>) {
    minPartitions("32")
}

private fun minPartitions(n: String): Int {
    // Problem
    // A decimal number is a deci-binary if each of its digits are either 0 or 1 without leading zeros
    // 101 and 1100 are deci-binary
    // 112 and 3001 are not

    // Given a string *n* that represents a positive decimal integer
    // Return the minimum number of positive deci-binary numbers needed so that they sum up to *n*

    // Case
    // n = "32"
    // 10 + 11 + 11 = 32
    // Output = 3

    // The minimum amount of deci-binary numbers needed is equal to the max digit

    var max = 0

    for (char in n) {
        val digit = char.toString().toInt()
        max = if (digit > max) digit else max
    }

    return max
}