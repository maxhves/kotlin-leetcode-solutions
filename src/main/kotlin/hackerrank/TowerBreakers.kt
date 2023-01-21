package hackerrank

fun towerBreakers(n: Int, m: Int): Int {
    // *n* towers
    // Each tower is of height *m*

    // Case
    // In: n = 2, m = 6
    // Out: 2

    return if (m == 1 || n % 2 == 0) 2 else 1
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val result = towerBreakers(n, m)

        println(result)
    }
}