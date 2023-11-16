package leetcode.medium

//region Problem

/**
 * Given an array of strings (nums) containing (n) unique binary strings of length (n), return a binary
 * string of length (n) that does not appear in (nums). If there are multiple answers, you may return
 * any of them.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - We need to find a string that doesn't already appear in the given array (nums).
 * - We could generate every possible string of length (n) and check if it exists.
 *
 * Steps
 * - Initialize a string (result) to "".
 * - Initialize a HashSet of String (numsSet).
 * - Iterate over (nums) and add the strings to th (numsSet).
 * - Create a loop while true (we envision an answer is always found):
 *   - If (result) is empty or shorter than (nums[0].length), append a "0".
 *   - Else; Iterate over (result), and for each iteration:
 *     - If (result) is not in (numsSet) return (result).
 *     - If (result[i]) is a "0", set it to be a "1".
 *     - If (result[i]) is a "1", set it to be a "0"
 */

//endregion

//region Solution

private fun main() {
    // Output: "11"
    findDifferentBinaryString(nums = arrayOf("01", "10"))

    // Output: "101"
    findDifferentBinaryString(nums = arrayOf("111", "011", "001"))
}

private fun findDifferentBinaryString(nums: Array<String>): String {
    val numsSet = HashSet<String>(nums.size)
    val numSize = nums[0].length
    val result = mutableListOf<Char>()

    for (num in nums) {
        numsSet.add(num)
    }

    while (true) {
        if (result.isEmpty() || result.size < numSize) {
            result.add('0')
        } else {
            for (i in result.indices) {
                if (result.joinToString("") !in nums) {
                    return result.joinToString("")
                }

                if (result[i] == '0') {
                    result[i] = '1'
                } else {
                    result[i] = '0'
                }
            }
        }
    }
}

//endregion
