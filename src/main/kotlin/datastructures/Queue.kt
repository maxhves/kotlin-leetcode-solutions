package datastructures

import java.util.LinkedList

class Queue<T> : Iterable<T> {
    private val list = LinkedList<T>()

    // Return the size of the queue
    fun size(): Int {
        return list.size
    }

    // Returns whether the queue is empty
    fun isEmpty(): Boolean {
        return size() == 0
    }

    // Peek the element at the front of the queue
    fun peek(): T {
        return list.peekFirst()
    }

    // Poll an element from the front of the queue
    fun poll(): T {
        return list.removeFirst()
    }

    // Add an element to the back of the queue
    fun offer(element: T) {
        list.addLast(element)
    }

    override fun iterator(): Iterator<T> {
        return list.iterator()
    }
}