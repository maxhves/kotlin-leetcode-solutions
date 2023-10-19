package leetcode.easy

//region Problem

/**
 * There is an undirected star graph consisting of `n` nodes labeled from `1` to `n`. A star
 * graph s a graph where there is one center node and exactly `n - 1` edges that connect the center
 * node with every other node.
 *
 * You are given a 2D integer array `edges` where each `edges[i] = [u_i, v_i]` indicates that there is an
 * edge between the nodes `u_i` and `v_i`.
 *
 * Return the center of the given star graph.
 */

//endregion

//region Test cases

/**
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 *
 * Input: [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 */

//endregion

//region Solution

private fun main() {
    findCenter(edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2)))
}

private fun findCenter(edges: Array<IntArray>): Int {
    val hashMap = HashMap<Int, Int>()

    for (node in edges) {
        val edgeFrom = node[0]
        val edgeTo = node[1]

        hashMap[edgeFrom] = if (hashMap.contains(edgeFrom)) hashMap[edgeFrom]!! + 1 else 1
        hashMap[edgeTo] = if (hashMap.contains(edgeTo)) hashMap[edgeTo]!! + 1 else 1
    }

    return hashMap.maxBy { it.value }.key
}

private fun findCenterAlternative(edges: Array<IntArray>): Int {
    if (edges[0][0] == edges[1][1]) {
        return edges [0][0]
    }
    if (edges[0][0] == edges[1][0]) {
        return edges[0][0]
    }
    if (edges[0][1] == edges[1][0]) {
        return edges [0][1]
    }
    if (edges[0][1] == edges[1][1]) {
        return edges[0][1]
    }
    return -1
}

//endregion