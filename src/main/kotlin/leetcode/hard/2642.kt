package leetcode.hard

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

//region Problem

/**
 * There is a directional weighted graph that consists of (n) nodes numbered from (0) to (n - 1). The
 * edges of the graph are initially represented by the given array (edges) where (edges[i] = [from i, to i,
 * edgeCost i]) meaning that there is an edge from (from i) to (to i) with the cost (edgeCost i).
 *
 * Implement the (Graph) class:
 * - (Graph(int n, int[][] edges)) initializes the object with (n) nodes and the given edges.
 * - (addEdge(int[] edge)) adds an edge to the list of edges where (edge = [from, to, edgeCost]). It is
 *   guaranteed that there is no edge between the two nodes before adding this one.
 * - (int shortestPath(int node1, int node2)) returns the minimum cost of a path from (node1) to (node2).
 *   If no path exists, return (-1). The cost of a path is the sum of the costs of the edges in the path.
 */

//endregion

//region Steps to solve

/**
 * ...
 */

//endregion

//region Solution

private fun main() {
    val graph = Graph(
        n = 4,
        edges = arrayOf(
            intArrayOf(0, 2, 5),
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 1),
            intArrayOf(3, 0, 3),
        ),
    )

    println(graph.shortestPath(3, 2))
    println(graph.shortestPath(0, 3))
    graph.addEdge(intArrayOf(1, 3, 4))
    println(graph.shortestPath(0, 3))
}

private class Graph(n: Int, edges: Array<IntArray>) : HashMap<Int, MutableList<IntArray>>() {
    init { for (e in edges) addEdge(e) }

    fun addEdge(edge: IntArray) {
        getOrPut(edge[0]) { mutableListOf() } += edge
    }

    fun shortestPath(node1: Int, node2: Int): Int =
        with(PriorityQueue<Pair<Int, Int>>(compareBy { it.second })) {
            add(node1 to 0)
            val visited = HashSet<Int>()
            while (isNotEmpty()) {
                val (n, wp) = poll()
                if (n == node2) return@with wp
                if (visited.add(n))
                    get(n)?.onEach { (_, s, w) -> add(s to (w + wp))}
            }
            -1
        }
}

//endregion
