package datastructures

import java.util.*

class PQueue<T : Comparable<T>> {
    // The number of elements currently inside the heap
    private var heapSize = 0

    // The internal capacity of the heap
    private var heapCapacity = 0

    // A dynamic list to track the elements inside the heap
    private var heap: List<T>? = null

    // This map keeps track of the possible indices a particular
    // node value is found in the heap. Having this mapping lets
    // us have o(log(n)) removals and O(1) element containment check
    // at the cost of some additional space and minor overhead
    private var map : Map<T, TreeSet<Int>> = HashMap()

    // TODO: Implement the rest of this class
    // TODO: Priority Queue Source Code: 2:16:00
}