package hackerrank

import java.util.*

private fun isBalanced(s: String): String {
    // Problem
    // Push into a queue
    // Remove from queue when it's buddy is found
    // If the list is empty then all is balanced?

    // Case
    // {[]()}
    // {
    // {[
    // {
    // {(
    // {
    val stack = Stack<Char>()

    for (i in s) {
        if (stack.isEmpty()) {
            stack.push(i)
        } else {
            val head = stack.peek()

            if (head == '{' && i == '}') {
                stack.pop()
            } else if (head == '(' && i == ')') {
                stack.pop()
            } else if (head == '[' && i == ']') {
                stack.pop()
            } else {
                stack.push(i)
            }
        }
    }

    return if (stack.isEmpty()) "YES" else "NO"
}

private fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val s = readLine()!!

        val result = isBalanced(s)

        println(result)
    }
}