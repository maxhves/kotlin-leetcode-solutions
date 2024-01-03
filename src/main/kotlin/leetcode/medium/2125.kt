package leetcode.medium

//region Problem

/**
 * Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string
 * array (bank) representing the floor plan of the bank, which is an (m x n) 2D matrix. (bank[i])
 * represents the (i th) row, consisting of '0's and '1's. '0' means the cell is empty, while '1' means
 * the cell has a security device.
 *
 * There is one laser beam between any two security devices if both conditions are met:
 * - The two devices are located on two different tows (r1) and (r2) where (r1 < r2).
 * - For each row (i)  where (r1 < i < r2), there are no security devices in the (i th) row.
 *
 * Laser beams are independent, i.e., one beam does not interfere nor join with another.
 *
 * Return the total number of laser beams in the bank.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Laser beams connect on different rows, going downward.
 * - They connect providing that there are no security devices in between, otherwise it would have simply
 *   connected with the row in between.
 *
 * - We can iterate over the rows and compare the previous to the current, counting up the number
 *   of laser beams we could make.
 * - This is potentially: (r2 * r1).
 */

//endregion

//region Solution

private fun main() {
    // Output: 8
    numberOfBeams(
        bank = arrayOf("011001", "000000", "010100", "001000"),
    )
}

private fun numberOfBeams(bank: Array<String>): Int {
    var previousSecurityDeviceCount = 0
    var beamCount = 0

    for (row in bank) {
        var currentSecurityDeviceCount = 0

        for (cell in row) {
            currentSecurityDeviceCount += cell.digitToInt()
        }

        beamCount += (currentSecurityDeviceCount * previousSecurityDeviceCount)

        if (currentSecurityDeviceCount != 0) {
            previousSecurityDeviceCount = currentSecurityDeviceCount
        }
    }

    return beamCount
}

//endregion
