package hackerrank

private fun minimumBribes(q: Array<Int>): Unit {
    // Case
    // 2 1 5 3 4
    // 5 moved 2 times
    // 2 moved 1 time
    //
    // 2 5 1 3 4
    // 5 moved 3 times
    // 2 moved 1 time

    // Thoughts
    // 5 is in index 4
    // 5 is now in index 1
    // 4 - 1 = 3
    // 1 2 3 4 5

    // TODO: Needs a proper explanation
    // Solution
    var totalBribes = 0
    var p1 = 1
    var p2 = 2
    var p3 = 3

    // Count 0 -> array size
    for (i in q.indices) {
        // Item at index
        when (q[i]) {
            p1 -> {
                p1 = p2
                p2 = p3
                p3++
            }
            p2 -> {
                totalBribes++

                p2 = p3
                p3++
            }
            p3 -> {
                totalBribes += 2

                p3++
            }
            else -> {
                // Now the expected item is beyond 2 places
                println("Too chaotic")
                return
            }
        }
    }

    println(totalBribes)
}

private fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}