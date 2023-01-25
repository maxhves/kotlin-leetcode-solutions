package hackerrank.easy

import java.util.*

// Initial solution
fun gradingStudents(grades: Array<Int>): Array<Int> {
    val mutableGrades = grades.toMutableList()

    for (i in mutableGrades.indices) {
        val grade = mutableGrades[i]

        if (grade >= 38) {
            // Modify this grade
            if ((grade + 1) % 5 == 0) {
                mutableGrades[i] = grade + 1
            } else if ((grade + 2) % 5 == 0) {
                mutableGrades[i] = grade + 2
            }
        }
    }

    return mutableGrades.toTypedArray()
}

// Improved solution
fun gradingStudents2(grades: Array<Int>): Array<Int> {
    val adjustedGrades = grades.map { grade ->
        if (grade < 38 || grade % 5 < 3) {
            grade
        } else {
            grade + (5 - grade % 5)
        }
    }
    return adjustedGrades.toTypedArray()
}

fun main(args: Array<String>) {
    val gradesCount = readLine()!!.trim().toInt()

    val grades = Array<Int>(gradesCount, { 0 })
    for (i in 0 until gradesCount) {
        val gradesItem = readLine()!!.trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}