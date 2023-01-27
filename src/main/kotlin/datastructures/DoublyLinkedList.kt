package datastructures

class DoublyLinkedList<T> : Iterable<T> {
    data class Node<T>(
        var data: T?,
        var prev: Node<T>? = null,
        var next: Node<T>? = null
    )

    private var size: Int = 0
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    // Empty this linked list, O(n)
    fun clear() {
        var trav = head

        while (trav != null) {
            val next = trav.next

            trav.prev = null
            trav.next = null
            trav.data = null
            trav = next
        }

        head = null
        tail = null
        size = 0
    }

    // Return the size of the linked list
    fun size(): Int {
        return size
    }

    // Return if the linked list is empty or not
    fun isEmpty(): Boolean {
        return size() == 0
    }

    // Add an element to the tail of the linked list, O(1)
    fun add(element: T) {
        addLast(element)
    }

    // Add an element to the beginning of this linked list, O(1)
    fun addFirst(element: T) {
        if (isEmpty()) {
            val newNode = Node(
                data = element,
            )
            head = newNode
            tail = newNode
        } else {
            val newNode = Node(
                data = element,
                next = head,
            )
            head?.prev = newNode
            head = head?.prev
        }

        size++
    }

    // Add a new node to the tail of the linked list, O(1)
    fun addLast(element: T) {
        if (isEmpty()) {
            val newNode = Node(
                data = element,
            )
            head = newNode
            tail = newNode
        } else {
            val newNode = Node(
                data = element,
                prev = tail
            )
            tail?.next = newNode
            tail = tail?.next
        }

        size++
    }

    // Check the value of the first node if it exists, O(1)
    fun peekFirst(): T? {
        return head?.data
    }

    // Check the value of the last node if it exists, O(1)
    fun peekLast(): T? {
        return tail?.data
    }

    // Remove the first value at the head of the linked list, O(1)
    fun removeFirst(): T? {
        if (isEmpty()) return null

        // Extract the data at the head and move the head pointer forward one node
        val data = head?.data
        head = head?.next
        size--

        if (isEmpty()) {
            tail = null
        } else {
            head?.prev = null
        }

        return data
    }

    // Remove the last value at the tail of the linked list, O(1)
    // TODO: Continue to implement this class
    // TODO: Data Structures Easy to Advanced Course - 54:04

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            private var traversal = head

            override fun hasNext(): Boolean {
                return traversal != null
            }
            override fun next(): T {
                val data = traversal?.data
                traversal = traversal?.next
                return data!!
            }
        }
    }
}