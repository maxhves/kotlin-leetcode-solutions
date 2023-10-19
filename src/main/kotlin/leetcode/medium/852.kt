package leetcode.medium

//region Problem

/**
 * An array `arr` is a mountain if the following properties hold:
 *  - `arr.length >= 3`
 *  - There exists some `i` with `0 < i < arr.length - 1` such that:
 *   - `arr[0] < arr[1] < ... < arr[i - 1] < arr[i]`
 *   - `arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`
 *
 * Given a mountain array `arr` return the index `i` such that `arr[0] < arr[1] < ... <
 * arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1]`.
 *
 * You must solve it in `O(log(arr.length))` time complexity.
 */

//endregion

//region Test cases

/**
 * Input: arr = [0,1,0]
 * Output: 1
 *
 * Input: arr = [0,2,1,0]
 * Output: 1
 *
 * Input: arr = [0,10,5,2]
 * Output: 1
 */

//endregion

//region Solution

private fun main() {
    peakIndexInMountainArray(arr = intArrayOf(0, 1, 0))
    peakIndexInMountainArray(arr = intArrayOf(0, 2, 1, 0))
    peakIndexInMountainArray(arr = intArrayOf(0, 10, 5, 2))
    peakIndexInMountainArray(arr = intArrayOf(3, 4, 5, 1))
}

private fun peakIndexInMountainArray(arr: IntArray): Int {
    var start = 0
    var end = arr.lastIndex

    while (start != end) {
        val midpoint = start + (end - start) / 2

        if (arr[midpoint] > arr[midpoint + 1]) {
            end = midpoint
        } else if (arr[midpoint] < arr[midpoint + 1]) {
            start = midpoint + 1
        }
    }

    return start
}

//endregion