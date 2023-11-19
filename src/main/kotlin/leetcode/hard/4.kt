package leetcode.hard

import kotlin.math.max
import kotlin.math.min

//region Problem

/**
 * Given two sorted arrays (nums1) and (nums2) of size (m) and (n) respectively, return the median of
 * the two sorted arrays.
 *
 * The overall run time complexity should be (O(log (m + n)).
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {

}

private fun findMedianSortedArray(nums1: IntArray, nums2: IntArray): Double {
    var a = nums1
    var b = nums2
    val total = nums1.size + nums2.size
    val half = total / 2

    if (b.size < a.size) {
        a = nums2
        b = nums1
    }

    var left = 0
    var right = a.size

    while (true) {
        val aMidpoint = (left + right) / 2
        val bMidpoint = half - aMidpoint

        val aLeft = if (aMidpoint > 0) a[aMidpoint - 1] else Int.MIN_VALUE
        val aRight = if (aMidpoint < a.size) a[aMidpoint] else Int.MAX_VALUE

        val bLeft = if (bMidpoint > 0) b[bMidpoint - 1] else Int.MIN_VALUE
        val bRight = if (bMidpoint < b.size) b[bMidpoint] else Int.MAX_VALUE

        if (aLeft <= bRight && bLeft <= aRight) {
            return if (total % 2 != 0) {
                minOf(aRight, bRight).toDouble()
            } else {
                (maxOf(aLeft, bLeft) + minOf(aRight, bRight)) / 2.0
            }
        } else if (aLeft > bRight) {
            right = aMidpoint - 1
        } else {
            left = aMidpoint + 1
        }
    }
}

//endregion
