package leetcode.easy

//region Problem

/**
 * You are given an integer array (arr). Sort the integers in the array in ascending order by the number
 * of (1)s in their binary representation and in case of two or more integers have the same number of (1)s
 * you have to sort them in ascending order.
 *
 * Return the array after sorting it.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We should use a sorting algorithm to sort the array into the right order.
 *
 * 1. Use a bubble sort algorithm.
 * 2. Create a loop that iterates over the (arr) array.
 * 3. For each iteration:
 *     - Create a loop that iterates from 1 to (arr.size - i).
 *     - Each iteration the max value will be placed at the end, so we no longer need to
 *       revisit this index.
 *     - Check how many bits are in the current element.
 *     - Check how many bits are in the previous element.
 *     - If the previous bits are greater than the current bits:
 *        - We should swap these two elements.
 *     - If the previous bits and current bits are the same:
 *        - If the previous element is greater than the current element:
 *           - We should swap these two elements.
 * 4. At the end, we simply return (arr) as this sort is done in-place.
 */

//endregion

//region Solution

private fun main() {
    // Output: [0,1,2,4,8,3,5,6,7]
    sortByBits(arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8))

    // Output: [1,2,4,8,16,32,64,128,256,512,1024]
    sortByBits(arr = intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1))
}

private fun sortByBits(arr: IntArray): IntArray {
    for (i in arr.indices) {
        for (j in 1 until arr.size - i) {
            val temp = arr[j]
            val currentOneBits = arr[j].countOneBits()
            val previousOneBits = arr[j - 1].countOneBits()

            if (previousOneBits > currentOneBits) {
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
            } else if (previousOneBits == currentOneBits) {
                if (arr[j - 1] > arr[j]) {
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp
                }
            }
        }
    }

    return arr
}

//endregion
