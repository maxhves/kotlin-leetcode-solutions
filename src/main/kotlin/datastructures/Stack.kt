package datastructures

import java.util.*

class Stack<T> : Iterable<T> {
    private val list = LinkedList<T>()

    // Return the number of elements in the stack
    fun size(): Int {
        return list.size
    }

    // Check if the stack is empty
    fun isEmpty(): Boolean {
        return size() == 0
    }

    // Push an element onto the stack
    fun push(element: T) {
        list.addLast(element)
    }

    // Pop an element off the stack
    fun pop(): T {
        return list.removeLast()
    }

    // Peek the top of the stack without removing an element
    fun peek(): T {
        return list.peekLast()
    }

    override fun iterator(): Iterator<T> {
        return list.iterator()
    }
}