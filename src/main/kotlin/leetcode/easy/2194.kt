package leetcode.easy

//region Problem

/**
 * A cell `(r, c)` of an excel sheet is represented as a string `"<col><row>"` where:
 *  - `<col>` denotes the column number `c` of the cell. It is represented by alphabetical letters
 *    - For example the `1st` column is denoted by `A` the `2nd` by `B`, etc.
 *  - `<row>` is thr row number `r` of the cell. The `rth` row is represented by the integer `r`.
 *
 *  You are given a string `s` in the format `"<col1><row1>:<col2><row2>"`, where `<col1>` represents the column
 *  `c1` and `<row2>` represents the row `r2`, such that `r1 <= r2` and `c1 <= c2`.
 *
 *  Return the list of cells `(x, y)` such that `r1 <= x <= r2` and `c1 <= y <= c2`. The cells should be represented
 *  as strings in the format mentioned above and be sorted in non-decreasing order first by columns and then by rows.
 */

//endregion

//region Test cases

/**
 * Input: "K1:L2".
 * Output: ["K1, "K2, "L1", "L2"]
 */

//endregion

//region Solution

private fun main() {
    cellsInRange(s = "K1:L2")
    cellsInRange(s = "A1:F1")
}

fun cellsInRange(s: String): List<String> {
    val upperCol = s[0]
    val lowerCol = s[3]
    val upperRow = s[1]
    val lowerRow = s[4]
    val result = ArrayList<String>()

    for (i in upperCol..lowerCol) {
        for (j in upperRow..lowerRow) {
            result.add("$i$j")
        }
    }

    return result
}

//endregion