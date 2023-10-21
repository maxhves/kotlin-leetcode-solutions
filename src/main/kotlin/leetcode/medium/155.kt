package leetcode.medium

//region Problem

/**
 * Design a stack that supports push, pop, top and retrieving the minimum element in constant time.
 *
 * Implement the (MinStack) class:
 *  - (MinStack()) initializes the stack object.
 *  - (void push(int val)) pushes the element (val) onto the stack.
 *  - (void pop()) removes the element on the top of the stack.
 *  - (int top()) gets the top element of the stack.
 *  - (int getMin()) retrieves the minimum element in the stack.
 *
 * You must implement a solution with (O(1)) time complexity for each function.
 */

//endregion

//region Steps to solve

/**
 * 1. I believe that a Stack under the hood, simply uses a dynamic array, therefore it makes sense for us
 *    to implement a solution that also utilizes a dynamic array, more than likely the Array class will
 *    suffice for this purpose,
 */

//endregion

//region Solution

private fun main() {
    // Test the MinStack class for stability.
    val minStack = MinStack()
    minStack.push(5)
    minStack.pop()
    minStack.push(1)
    minStack.push(2)
    val top = minStack.top()
    val min = minStack.getMin()
    minStack.push(3)
    minStack.pop()

    val t = ""
}

private class MinStack {
    var elements = ArrayList<Int>()
    var minElements = ArrayList<Int>()

    fun push(`val`: Int) {
        if (minElements.isEmpty() || `val` < minElements[minElements.lastIndex]) {
            minElements.add(`val`)
        } else {
            minElements.add(minElements[minElements.lastIndex])
        }

        elements.add(`val`)
    }

    fun pop() {
        elements.removeAt(elements.lastIndex)
        minElements.removeAt(minElements.lastIndex)
    }

    fun top(): Int {
        return elements[elements.lastIndex]
    }

    fun getMin(): Int {
        return minElements[minElements.lastIndex]
    }
}

//endregion
