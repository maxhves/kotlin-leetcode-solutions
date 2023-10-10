package leetcode.easy

//region Problem

/**
 * Given an `n x n` binary matrix `image`, flip the image horizontally, then invert it, and return the
 * resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 *  - For example, flipping `[1,1,0]` horizontally results in `[0,1,1]`.
 *
 *  To invert an image means that each `0` is replaced by `1` and each `1` is replaced by `0`.
 *   - For example, inverting `[0,1,1]` results in `[1,0,0]`.
 */

//endregion

//region Test cases

/**
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */

//endregion

//region Steps to solve

/**
 * Initial and slow way:
 * 1. Iterate over each row.
 * 2. Reverse the row.
 * 3. Flip each element.
 * 4. Return the resulting array.
 */

//endregion

//region Solution

private fun main() {
    flipAndInvertImage(
        image = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
        )
    )
}

private fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
    val size = image.size - 1

    for (i in 0..size) {
        val newIntArray = IntArray(size + 1)

        for (j in 0..size) {
            newIntArray[j] = image[i][size - j] xor 1
        }

        image[i] = newIntArray
    }

    return image
}

//endregion