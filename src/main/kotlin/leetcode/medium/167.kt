package leetcode.medium

//region Problem

/**
 * Given a 1-indexed array of integers (numbers) that is already sorted in non-decreasing order, find
 * two numbers such that they add up to a specific (target) number. Let these two numbers be
 * (numbers[index1]) and (numbers[index2]) where (i <= index1 < index2 < numbers.length).
 *
 * Return the indices of the two numbers, (index1) and (index2), added by one as an integer array
 * ([index1, index2]) of length 2.
 *
 * Your solution must use only constant extra space.
 */

//endregion

//region Steps to solve

/**
 * 1. Initialize two variables, left and right, these are pointers.
 *    - Left will initially be 0.
 *    - Right will initially be numbers.lastIndex.
 * 2. Create a condition to loop whilst left is smaller than right.
 * 3. For each iteration:
 *    - Compare numbers[left] and numbers[right]:
 *      - If numbers[left] + numbers[right]
 *        - Return an integer array of left, right.
 *      - If numbers[left] + numbers[right] is greater than the target:
 *        - Decrease right by one.
 *      - If numbers[left] + numbers[right] is smaller than the target:
 *        - Increase left by one.
 * 4. By the end, return an integer array of left, right, as they must be the answer.
 */

//endregion

//region Solution

private fun main() {
    // Output: [1, 2]
    twoSum(numbers = intArrayOf(2, 7, 11, 15), target = 9)

    // Output: [1, 3]
    twoSum(numbers = intArrayOf(2, 3, 4), target = 6)

    // Output: [1, 2]
    twoSum(numbers = intArrayOf(-1, 0), target = -1)
}

private fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex

    while (left < right) {
        val sum = numbers[left] + numbers[right]

        when {
            sum == target -> break
            sum > target -> {
                right--
            }
            sum < target -> {
                left++
            }
        }
    }

    return intArrayOf(left + 1, right + 1)
}

//endregion
