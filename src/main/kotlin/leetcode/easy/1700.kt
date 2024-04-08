package leetcode.easy

//region Problem

/**
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers
 * 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular
 * sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are
 * placed in a stack. At each step:
 *
 * - If the student at the front of the queue prefers the sandwich on the top of the stack, they
 *   will take it and leave the queue.
 *
 * - Otherwise, they will leave it and go to the queue's end.
 *
 * This continues until none of the queue students want to take the top sandwich and thus are unable
 * to eat.
 *
 * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the
 * ith sandwich in the stack (i = 0 is the top of the stack) and students[i] is the preference of the
 * jth student in the initial queue (j = 0 is the front of the queue). Return the number of students
 * that are unable to eat.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Simulation of scenario 2.
 *   - First
 *     - st: 1 1 1 0 0 1
 *     - sa: 1 0 0 0 1 1
 *   - Second
 *     - st: 1 1 0 0 1
 *     - sa: 0 0 0 1 1
 *   - Third
 *     - st: 1 0 0 1 1
 *     - sa: 0 0 0 1 1
 *   - Fourth
 *     - st: 0 0 1 1 1
 *     - sa: 0 0 0 1 1
 *   - Fifth
 *     - st: 0 1 1 1
 *     - sa: 0 0 1 1
 *   - Sixth
 *     - st: 1 1 1
 *     - sa: 0 1 1
 *   - No more students can eat because they only want 1, but we have a 0 on the stack.
 *
 * - We need to know when we have exhausted all the remaining students without them taking a sandwich.
 * -
 */

//endregion

//region Solution

private fun main() {
    // Output: 0
    countStudents(
        students = intArrayOf(1, 1, 0, 0),
        sandwiches = intArrayOf(0, 1, 0, 1),
    )

    // Output: 3
    countStudents(
        students = intArrayOf(1, 1, 1, 0, 0, 1),
        sandwiches = intArrayOf(1, 0, 0, 0, 1, 1),
    )
}

private fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val studentsStack = ArrayDeque<Int>()
    val sandwichesStack = ArrayDeque<Int>()

    // Fill our deque
    for (i in students.indices) {
        studentsStack.addLast(students[i])
        sandwichesStack.addLast(sandwiches[i])
    }

    // Try to get every student to eat.
    var iterations = 0
    while (sandwichesStack.isNotEmpty() && iterations < students.size + sandwiches.size) {
        val student = studentsStack.removeFirst()
        val sandwich = sandwichesStack.removeFirst()

        if (student != sandwich) {
            studentsStack.addLast(student)
            sandwichesStack.addFirst(sandwich)
        } else {
            iterations = 0
        }

        iterations++
    }

    return studentsStack.size
}

//endregion
