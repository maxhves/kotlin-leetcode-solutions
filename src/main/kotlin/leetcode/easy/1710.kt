package leetcode.easy

import kotlin.math.max

//region Problem

/**
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array (boxTypes), where
 * (boxTypes[i] = [numOfBoxes, numberOfUnitsPerBox]):
 *  - (numberOfBoxes i) is the number of type (i).
 *  - (numberOfUnitsPerBox i) is the number of units in each box of the type (i).
 *
 * You are also given an integer (truckSize), which is the maximum number of boxes that can be put on the
 * truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed
 * (truckSize).
 *
 * Return the maximum total number of units that can be put on the truck.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 *  - We are looking for the maximum number of units that can fit into the truck.
 *  - We could sort the array by the unit size.
 *  - Then we could start taking items from the end until we reach the (truckSize).
 *
 * 1. Run a sorting algorithm (we can use a built-in function for this) and sort the array by
 *    units, we could sort by descending.
 * 2. Iterate over the now sorted (boxTypes) array.
 * 3. For elements in the array:
 *    - Take boxes for a count that is equal to the (truckSize).
 *    - Stop when the (truckSize) is reached.
 *    - When taking a box, increment a count of the units we are taking.
 * 4. Return the resulting unit count.
 */

//endregion

//region Solution

private fun main() {
    // Output 8
    maximumUnits(
        boxTypes = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 2),
            intArrayOf(3, 1),
        ),
        truckSize = 4,
    )

    // Output 91
    maximumUnits(
        boxTypes = arrayOf(
            intArrayOf(5, 10),
            intArrayOf(2, 5),
            intArrayOf(4, 7),
            intArrayOf(3, 9),
        ),
        truckSize = 10,
    )
}

private fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    boxTypes.sortByDescending { it[1] }

    var unitsTaken = 0
    var maxBoxes = truckSize

    for (boxType in boxTypes) {
        val (numberOfBoxes, unitsPerBox) = boxType
        val boxesToLoad = numberOfBoxes.coerceAtMost(maxBoxes)

        unitsTaken += boxesToLoad * unitsPerBox
        maxBoxes -= boxesToLoad

        if (maxBoxes == 0) break
    }

    return unitsTaken
}

//endregion
