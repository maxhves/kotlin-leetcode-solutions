package leetcode.easy

//region Problem

/**
 * You are given a 0-indexed string (num) of length (n) consisting of digits.
 *
 * Return (true) if for every index (i) in the range (0 <= i < n), the digit (i) occurs (num[i]) times
 * in num, otherwise return false.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We are to find out whether the frequency of the elements is equal to that of its index value.
 *
 * 1. Create a HashMap<Int, Int>:
 *     - Key: Digit.
 *     - Value: Frequency.
 * 2. Iterate over the (num) array.
 * 3. For each element:
 *     - Insert if not present.
 *     - Otherwise; increase the frequency of the digit.
 * 4. Iterate over the array again.
 * 5. For each element:
 *     - Check if the value at HashMap[digit] is equal to the index.
 *     - Return false if it isn't.
 * 6. If we reach this point; return true.
 */

//endregion

//region Solution

private fun main() {
    // Output: true
    digitCount(num = "1210")
}

private fun digitCount(num: String): Boolean {
    val digitFrequencies = HashMap<Int, Int>(10)

    for (i in num.indices) {
        val digit = num[i].digitToInt()
        digitFrequencies[digit] = digitFrequencies.getOrDefault(digit, 0) + 1
    }

    for (i in num.indices) {
        val digit = num[i].digitToInt()
        val digitFrequency = digitFrequencies.getOrDefault(i, 0)

        if (digitFrequency != digit) {
            return false
        }
    }

    return true
}

//endregion
