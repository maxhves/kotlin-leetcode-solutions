package hackerrank

private fun legoBlocks(n: Int, m: Int): Int {
    // Brick configs
    //  d	h	w
    //  1	1	1
    //  1	1	2
    //  1	1	3
    //  1	1	4

    // Case
    // 2 2
    //

    val modulo = 1000000007
    return 0
}

private fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val n = first_multiple_input[0].toInt()

        val m = first_multiple_input[1].toInt()

        val result = legoBlocks(n, m)

        println(result)
    }
}