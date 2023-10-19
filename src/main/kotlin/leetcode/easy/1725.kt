package leetcode.easy

import kotlin.math.max

//region Problem

/**
 * You are given an array (rectangles) where (rectangles[i] = [li, wi]) represents the (ith) rectangle
 * of length (li) and width (wi).
 *
 * You can cut the (ith) rectangle to form a square with a side length of (k) if both (k <= li) and
 * (k <= wi). For example, if you have a rectangle ([4, 6]), you can cut it to get a square with a side
 * length of at most (4).
 *
 * Let (maxLength) be the side length of the largest square you can obtain from any of the given rectangles.
 *
 * Return the number of rectangles that can make a square with a side length of (maxLen).
 */

//endregion

//region Steps to solve

/**
 * 1. Iterate over the array:
 *    - Find the min of both items in the array (we know there's ony two elements).
 *    - Keep track of a (maxLength) number, updating if we have an element that is greater.
 *    - Also store in an array, all max lengths of each rectangle.
 * 2. Return a count of how many rectangles could be cut down/fit into our current largest (maxLength).
 */

//endregion

//region Solution

private fun main() {
    // Output: 3
    countGoodRectangles(
        rectangles = arrayOf(
            intArrayOf(5, 8),
            intArrayOf(3, 9),
            intArrayOf(5, 12),
            intArrayOf(16, 5),
        ),
    )

    // Output: 3
    countGoodRectangles(
        rectangles = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(3, 7),
            intArrayOf(4, 3),
            intArrayOf(3, 7),
        ),
    )
}

private fun countGoodRectangles(rectangles: Array<IntArray>): Int {
    var maxLength = 0
    val maxSquareSize = IntArray(rectangles.size)

    for (i in rectangles.indices) {
        val squareSide = minOf(rectangles[i][0], rectangles[i][1])
        maxSquareSize[i] = squareSide

        maxLength = maxOf(maxLength, squareSide)
    }

    return maxSquareSize.fold(0) { acc, i -> if (i >= maxLength) acc + 1 else acc }
}

//endregion
