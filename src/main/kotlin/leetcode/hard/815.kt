package leetcode.hard

import java.util.ArrayDeque

//region Problem

/**
 * You are given an array (routes) representing bus routes where (routes[i]) is a bus route that the (ith)
 * bus repeats forever.
 * - For example, if (routes[0] = [1, 5, 7]), this means that the (0th) bus travels in the sequence
 *   (1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ...) forever.
 *
 * You will start at the bus stop (source). You are not on any bus initially, and you want to go to the
 * bus stop (target). You can travel between bus stops by buses only.
 *
 * Return the least number of buses you must take to travel from (source) to (target). Return (-1) if it
 * is not possible.
 */

//endregion

//region Steps to solve

/**
 * Considerations:
 * - This is a BFS problem.
 *
 * Steps:
 * -
 */

//endregion

//region Solution

private fun main() {

}

private fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    val routeToStops = mutableMapOf<Int, MutableList<Int>>()
    routes.forEachIndexed { buses, routes ->
        routes.forEach { stop ->
            routeToStops.getOrPut(stop) { mutableListOf() } += buses
        }
    }

    val visitedStops = mutableSetOf<Int>()
    val visitedRoutes = mutableSetOf<Int>()
    val q = ArrayDeque<Pair<Int, Int>>()
    q += source to 0

    while (q.isNotEmpty()) {
        val (stop, count) = q.poll()

        if (stop == target) return count
        if (stop in visitedStops) continue

        visitedStops += stop
        for (r in routeToStops[stop]!!) {
            if (r in visitedRoutes) continue
            for (s in routes[r]) {
                if (s in visitedStops) continue
                q += s to count + 1
                visitedRoutes += r
            }
        }
    }

    return -1
}

//endregion
