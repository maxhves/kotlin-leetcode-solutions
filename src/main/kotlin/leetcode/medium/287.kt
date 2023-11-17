package leetcode.medium

//region Problem

/**
 * Given an array of integers (nums) containing (n + 1) integers where each integer is in the range
 * ([1, n]) inclusive.
 *
 * There is only one repeated number in (nums), return this repeated number.
 *
 * You must solve the problem without modifying the array (nums) and use only constant extra space.
 */

//endregion

//region Steps to solve

/**
 * Considerations
 * - The array can act as a LinkedList, and we can use a fast and slow pointers to find a cycle.
 *
 * Steps
 * - Initialize a (fast) variable, set to 0.
 * - Initialize a (slow) variable set to 0.
 * - Create a while loop, simply while true:
 *   - Set (slow) to (nums[slow])
 *     - Essentially this is setting (slow) to the next node.
 *   - Set (fast) to (nums[nums[fast]]).
 *     - Essentially this is setting (fast) to the next next node.
 *   - If (slow) is equal to (fast); break out of the loop.
 * - Initialize a new pointer (slowIntersection) set to 0.
 * - Create a while loop, simply while true:
 *   - Set (slow) and (slowIntersection) to the next node (nums[slow/slowIntersection]).
 *   - If (slow) becomes equal to (slowIntersection):
 *     - Return one of the pointers, they are the same value.
 */

//endregion

//region Solution

private fun main() {
    // Output: 2
    findDuplicate(nums = intArrayOf(1, 3, 4, 2, 2))

    // Output: 3
    findDuplicate(nums = intArrayOf(3, 1, 3, 4, 2))
}

private fun findDuplicate(nums: IntArray): Int {
    var fast = 0
    var slow = 0

    while (true) {
        slow = nums[slow]
        fast = nums[nums[fast]]

        if (fast == slow) {
            break
        }
    }

    var slowIntersection = 0
    while (true) {
        slow = nums[slow]
        slowIntersection =  nums[slowIntersection]

        if (slow == slowIntersection) {
            return slow
        }
    }
}

//endregion
