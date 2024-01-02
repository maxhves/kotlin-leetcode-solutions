package leetcode.medium

//region Problem

/**
 * You are given an integer array (nums). You need to create a 2D array from (nums) satisfying the
 * following conditions:
 * - The 2D array should contain only the elements of the array (nums).
 * - Each row in the 2D array contains distinct integers.
 * - The number of rows in the 2D array should be minimal.
 *
 * Return the resulting array. If there are multiple answers, return any of them.
 *
 * Note that the 2D array can have a different number of elements on each row.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - By using a frequency hash map we can keep track of which row the next element should be in.
 *   - When adding an element (i) it's frequency will be 1, this means that the next occurrence of (i)
 *     should be placed into the row with an index of 1.
 *   - We then update the frequency map.
 * - We can then iterate over each element in (nums).
 *   - Get the current frequency of the element (or 0).
 *   - Check if the row at this index exists.
 *     - If not; create the row.
 *   - Add the element to the matrix.
 *   - Update the element frequency map.
 * Return the matrix.
 */

//endregion

//region Solution

private fun main() {
    // Output: [[1, 3, 4, 2], [1, 3], [1]]
    findMatrix(
        nums = intArrayOf(1, 3, 4, 1, 2, 3, 1),
    )
}

private fun findMatrix(nums: IntArray): List<List<Int>> {
    val matrix = mutableListOf<MutableList<Int>>()
    val elementFrequencies = HashMap<Int, Int>(nums.size)

    for (element in nums) {
        val currentFrequency = elementFrequencies.getOrDefault(element, 0)

        if (matrix.getOrNull(currentFrequency) == null) {
            matrix.add(mutableListOf())
        }

        matrix[currentFrequency].add(element)
        elementFrequencies[element] = currentFrequency + 1
    }

    return matrix
}

//endregion
