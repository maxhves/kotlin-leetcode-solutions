package leetcode.easy

//region Problem

/**
 * There is a class with 'm' students and 'n' exams. You are given a 0-indexed 'm x n' integer matrix
 * 'score', where each row represents one student and 'score[i][j]' denotes the score the 'ith' student got
 * in the 'jth' exam. The matrix 'score' contains distinct integers only'
 *
 * You are also given an integer 'k'. Sort the students (i.e, the rows of the matrix by their scores in the
 * 'kth' (0-indexed) exam from the highest to the lowest.
 *
 * Return the matrix after sorting it.
 */

//endregion

//region Steps to solve

/**
 * Can we simply use a sort by function?
 */

//endregion

//region Solution

private fun main() {
    // Output: [[7,5,11,2],[10,6,9,1],[4,8,3,15]]
    sortTheStudents(
        score = arrayOf(intArrayOf(10, 6, 9, 1), intArrayOf(7, 5, 11, 2), intArrayOf(4, 8, 3, 15)),
        k = 2,
    )
}

private fun sortTheStudents(score: Array<IntArray>, k: Int): Array<IntArray> {
    score.sortByDescending { it[k] }
    return score
}

//endregion
