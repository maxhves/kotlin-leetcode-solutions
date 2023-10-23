package leetcode.medium

//region Problem

/**
 * Given an integer array (nums), return al the triplets ([nums[i], nums[j], nums[k]]), such that
 * (i != j), (i != k) and (j != k), and (nums[i] + nums[j] + nums[j] == 0).
 *
 * Notice that the solution set must not contain duplicate triplets.
 */

//endregion

//region Steps to solve

/**
 * We are looking for as many "triplets" as possible.
 *  - A triplet will be a set of three numbers that add up to 0.
 *  - Each triplet may not use duplicates, therefore each must be distinct.
 *    - Duplicates meaning that the same index cannot be reused.
 *
 * 1. Sort the (nums) array, making it easy for two pointer comparison.
 * 2. Iterate from 0 to (nums).lastIndex - 2.
 * 3. Initialize a HashSet to keep track of our current triplet.
 * 4. Inside the for loop, do the following:
 *    - Initialize a left and right pointer:
 *      - Left: (i) + 1
 *      - Right: (nums).lastIndex
 *    - Initialize a while loop, while left < right:
 *      - If left is in our current HashSet
 *        - Increase left
 *      - If right is in our current HashSet
 *        - Decease right
 *      - If HashSet + left + right == 0
 *        - Add left and right to HashSet
 *        - Continue
 *      - If HashSet + left + right > 0
 *        - Decrease right
 *      - If HashSet + left + right < 0
 *        - Increase left
 * 5. Finally return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    // Output: [[-1, -1, 2], [-1, 0, 1]]
    threeSum(nums = intArrayOf(-1, 0, 1, 2, -1, -4))

    // Output: []
    threeSum(nums = intArrayOf(0, 1, 1))

    // Output: [[0, 0, 0]]
    threeSum(nums = intArrayOf(0, 0, 0))
}

private fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val answers = HashSet<List<Int>>()

    for (i in 0 .. nums.lastIndex - 2) {
        val currentElement = nums[i]
        var left = i + 1
        var right = nums.lastIndex

        while (left < right) {
            val sum = currentElement + nums[left] + nums[right]

            if (sum > 0) {
                right--
            } else if (sum < 0) {
                left++
            } else {
                answers.add(listOf(currentElement, nums[left], nums[right]))
                left++
                right--
            }
        }
    }

    return answers.toList()
}

//endregion
