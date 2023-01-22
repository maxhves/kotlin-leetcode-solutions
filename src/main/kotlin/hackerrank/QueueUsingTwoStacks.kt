package hackerrank

import java.util.Stack

class Queue() {
    private val inputStack = Stack<String>()
    private val outputStack = Stack<String>()

    fun enqueue(element: String) {
        inputStack.push(element)
    }

    fun dequeue() {
        peek()
        outputStack.pop()
    }

    fun peek(): String {
        if (outputStack.isEmpty()) {
            while (inputStack.isNotEmpty()) {
                outputStack.push(inputStack.pop())
            }
        }
        return outputStack.peek()
    }
}

sealed class Query {
    data class Enqueue(val element: String) : Query()
    object Dequeue : Query()
    object Peek : Query()

    companion object {
        fun fromRawString(raw: String): Query {
            return when (raw) {
                "2" -> Dequeue
                "3" -> Peek
                else -> {
                    val element = raw.removeRange(0, 1).trim()
                    Enqueue(element)
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    // Thoughts
    // Two stacks?
    // Process a number of queries *q*
    // Each query is one of three types
    // - Add element x into the end of the queue
    // - Remove the element at the front of the queue
    // - Print the element at the front of the queue

    // Input format
    // First line: *q* denoting number of queries
    // If 1 then x is given after for enqueuing
    // Else just standard number
    val queue = Queue()

    val numOfQueries = readLine()!!.trim().toInt()

    for (queryCount in 1..numOfQueries) {
        when (val rawQuery = Query.fromRawString(readLine()!!.trim())) {
            Query.Dequeue -> queue.dequeue()
            is Query.Enqueue -> queue.enqueue(rawQuery.element)
            Query.Peek -> {
                println(queue.peek())
            }
        }
    }
}