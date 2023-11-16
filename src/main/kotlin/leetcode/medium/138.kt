package leetcode.medium

//region Problem

/**
 * A linked list of length (n) is given such that each node contains an additional random pointer, whichc
 * could point to any node in the list, or (null).
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly (n) brand new nodes, where
 * each new node has its values set to the value of its corresponding original node. Both the (next) and
 * (random) pointer of the new nodes shoul point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the pointers in the new list
 * should point to nodes in the original list.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {

}

private class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

private fun copyRandomList(node: Node?): Node? {
    node ?: return null

    val flatNodes = HashMap<Node, Node>()
    var current: Node? = node

    // Insert a new node with the original as the key.
    while (current != null) {
        flatNodes[current] = Node(current.`val`)
        current = current.next
    }

    // Connect each node based on its original connection.
    for ((original, copy) in flatNodes) {
        copy.next = flatNodes[original.next]
        copy.random = flatNodes[original.random]
    }

    return flatNodes[node]
}

//endregion
