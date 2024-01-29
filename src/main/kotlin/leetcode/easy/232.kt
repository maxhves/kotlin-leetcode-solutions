package leetcode.easy

import datastructures.Stack

//region Problem

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should
 * support all the functions of a normal queue (push, peek, pop and empty).
 *
 * Implement the MyQueue class:
 * - void push(int x) Pushes element x to the back of the queue.
 * - int pop() Removes the element from the front of the queue and returns it.
 * - int peek() Returns the element at the front of the queue.
 * - boolean empty() Returns true if the queue is empty, false otherwise.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - First in first out means that the firs item that goes into the queue should be the first item
 *   that comes out of the queue.
 * - A stack does not follow this ruling, as when you add an item to a stack the first item that comes
 *   out is the last item that was added.
 * - Can we simply add all items to a stack and then take those items and add them to a second stack
 *   when retrieving? This is surely not optimal.
 */

//endregion

//region Solution

private fun main() {
    val queue = MyQueue()
    queue.push(1)
    queue.push(2)
    queue.peek()
    queue.pop()
    queue.empty()
}

private class MyQueue {
    val writeStack = Stack<Int>()
    val readStack = Stack<Int>()

    fun push(x: Int) {
        writeStack.push(x)
    }

    fun pop(): Int {
        if (readStack.isEmpty()) {
            while (!writeStack.isEmpty()) {
                readStack.push(writeStack.pop())
            }
        }
        return readStack.pop()
    }

    fun peek(): Int {
        if (readStack.isEmpty()) {
            while (!writeStack.isEmpty()) {
                readStack.push(writeStack.pop())
            }
        }
        return readStack.peek()
    }

    fun empty(): Boolean {
        return writeStack.isEmpty() && readStack.isEmpty()
    }
}

//endregion
