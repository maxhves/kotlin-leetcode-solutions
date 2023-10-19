package leetcode.hard

import leetcode.common.MountainArray

//region Problem

/**
 * You may recall that an array `arr` is a mountain array if and only if:
 *  - `arr.length >= 3`
 *  - There exists some i with 0 < i < arr.length - 1 such that:
 *   - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *   - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 *
 *  Given a mountain array `mountainArr`, return the minimum `index` such that `mountainArr.get(index) == target`.
 *  If such an index does not exist, return `-1`.
 */

//endregion

//region Test cases

/**
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 *
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 */

//endregion

//region Solution

private fun main() {

}

private fun findInMountainArray(target: Int, mountainArray: MountainArray): Int {
    val peak = findPeakInMountain(mountainArray)
    val matchInStart = findTargetInArray(mountainArray, target, peak, true)

    return if (matchInStart != -1) {
        matchInStart
    } else {
        findTargetInArray(mountainArray, target, peak, false)
    }
}

private fun findPeakInMountain(array: MountainArray): Int {
    var start = 0
    var end = array.length() - 1

    while (start != end) {
        val midpoint = start + (end - start) / 2

        if (array.get(midpoint) > array.get(midpoint + 1)) {
            end = midpoint
        } else {
            start = midpoint + 1
        }
    }

    return start
}

private fun findTargetInArray(
    array: MountainArray,
    target: Int,
    peakIndex: Int,
    checkStart: Boolean,
): Int {
    var start = if (checkStart) 0 else peakIndex
    var end = if (checkStart) peakIndex else array.length() - 1

    while (start != end) {
        val midpoint = start + (end - start) / 2

        if (array.get(midpoint) == target) {
            return midpoint
        } else {
            if (checkStart) {
                if (array.get(midpoint) > target) {
                    end = midpoint
                } else {
                    start = midpoint + 1
                }
            } else {
                if (array.get(midpoint) > target) {
                    start = midpoint + 1
                } else {
                    end = midpoint
                }
            }
        }
    }

    return if (array.get(start) == target) start else -1
}

//endregion