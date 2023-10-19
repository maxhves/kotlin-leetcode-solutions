package hackerrank.easy

import java.util.*

private fun countingValleys(steps: Int, path: String): Int {
    // DDUUUUDD
    // -1, -1, +1, +1, +1, +1, -1, -1

    val stack = Stack<Int>()
    var valleyCount = 0

    for (i in 0 until steps) {
        if (stack.isEmpty()) {
            if (path[i] == 'D') {
                valleyCount++
                stack.push(-1)
            } else {
                stack.push(1)
            }
        } else if (path[i] == 'D') {
            if (stack.peek() == 0) {
                valleyCount++
            }
            stack.push(stack.peek() - 1)
        } else if (path[i] == 'U') {
            stack.push(stack.peek() + 1)
        }
    }

    return valleyCount
}

private fun main(args: Array<String>) {
    val steps = readLine()!!.trim().toInt()

    val path = readLine()!!

    val result = countingValleys(steps, path)

    println(result)
}