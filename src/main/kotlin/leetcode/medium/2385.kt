package leetcode.medium

import leetcode.common.TreeNode

//region Problem

/**
 * You are given the (root) of a binary tree with unique values, and an integer (start). At minute (0),
 * and infection starts from the node with the value (start).
 *
 * Each minute, a node becomes infected if:
 * - The node is currently uninfected.
 * - The node is adjacent to an infected node.
 *
 * Return the number of minutes needed for the entire tree to be infected.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * - Initialize some needed variables:
 *   - (graph): HashMap<Int, List<Int>>.
 *   - (queue): ArrayDeque<Pai<Int, Int>>.
 *   - (visited): Set<Int>.
 *
 * - Create the graph, by traversing each node and adding child/parent neighbor relationships for
 *   each node we traverse.
 * - Add the start element to the queue.
 * - While the queue is not empty:
 *   - Pop the first item from the queue.
 *   - Add it to the visited set.
 *   - Iterate over each neighbor for the current elements neighbors.
 *     - If the neighbor has not been visited: add the neighbor to the queue.
 */

//endregion

//region Solution

private fun main() {
    val root = TreeNode(1)
    val five = TreeNode(5)
    val four = TreeNode(4)
    val nine = TreeNode(9)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val ten = TreeNode(10)
    val six = TreeNode(6)
    root.left = five
    root.right = three
    five.right = four
    four.left = nine
    four.right = two
    three.left = ten
    three.right = six

    // Output: 4
    amountOfTime(root, 3)
}

private fun amountOfTime(root: TreeNode?, start: Int): Int {
    val graph = HashMap<Int, MutableList<Int>>()
    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = mutableSetOf<Int>()

    fun createGraph(node: TreeNode?) {
        node ?: return

        val element = node.`val`

        node.left?.`val`?.let { leftElement ->
            graph.getOrPut(element) { mutableListOf() } += leftElement
            graph.getOrPut(leftElement) { mutableListOf() } += element
        }
        node.right?.`val`?.let { rightElement ->
            graph.getOrPut(element) { mutableListOf() } += rightElement
            graph.getOrPut(rightElement) { mutableListOf() } += element
        }

        createGraph(node.left)
        createGraph(node.right)
    }

    createGraph(root)
    queue.add(start to 0)
    var minutes = 0

    while (queue.isNotEmpty()) {
        val elementAndMinute = queue.removeFirst()
        visited.add(elementAndMinute.first)
        minutes = maxOf(minutes, elementAndMinute.second)

        for (neighbor in graph.getOrDefault(elementAndMinute.first, emptyList())) {
            if (neighbor !in visited) {
                queue.addLast(neighbor to elementAndMinute.second + 1)
            }
        }
    }

    return minutes
}

//endregion
