package leetcode.medium

//region Problem

/**
 * You are given an integer array (target) and an integer (n).
 *
 * You have an empty stack with the two following operations:
 *  - ("Push"): pushes an integer to the top of the stack.
 *  - ("Pop"): removes the integer on the top of the stack.
 *
 * You also have a stream of the integers in the range ([1, n]).
 *
 * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to
 * (target). You should follow the following rules:
 *  - If the stream of the integers is not empty, pick the next integer from the stream and push it to the
 *    top of the stack.
 *  - If the stack is not empty, pop the integer at the top of the stack.
 *  - If, at any moment, the elements in the stack (from the bottom to the top) are equal to (target), do
 *    not read new integers from the stream and do not do more operations on the stack.
 *
 * Return the stack operations needed to build (target) following the mentioned rules. If there are multiple
 * valid answer, return any of them.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We need to create a stack that is equal to the target integer array.
 *  - Meaning from bottom -> top it must "appear" the same.
 *  - We have a "stream" of integers (a range) from 1 to (n).
 *  - We must use this to build our stack.
 *
 * 1. Create an empty array to hold our stack operation strings.
 * 2. Create a loop; for each element in target.
 * 3. For each item (i):
 *     - Create a loop; from last pushed element to (n).
 *     - If (j) is equal to (i):
 *        - "Push" the element.
 *        - Last pushed element = (j).
 *        - Break; move onto next (i) iteration.
 *     - If (j) is not equal to (i):
 *        - "Push" the element.
 *        - "Pop" the element.
 *        - Move onto next (j).
 * 4. Ultimately return the operations array.
 */

//endregion

//region Solution

private fun main() {
    // Output: ["Push","Push","Pop","Push"]
    buildArray(target = intArrayOf(1, 3), n = 3)

    // Output: ["Push","Push","Push"]
    buildArray(target = intArrayOf(1, 2, 3), n = 3)

    // Output: ["Push","Push"]
    buildArray(target = intArrayOf(1, 2), n = 4)
}

private fun buildArray(target: IntArray, n: Int): List<String> {
    val operations = mutableListOf<String>()
    var current = 1
    var targetIndex = 0

    while (current <= n && targetIndex < target.size) {
        if (current == target[targetIndex]) {
            operations.add("Push")
            targetIndex++
        } else {
            operations.add("Push")
            operations.add("Pop")
        }
        current++
    }

    return operations
}

//endregion
