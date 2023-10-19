package hackerrank.easy

private fun hurdleRace(k: Int, height: Array<Int>): Int {
    val doses = height.max() - k
    return if (doses < 0) 0 else doses
}

private fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val height = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = hurdleRace(k, height)

    println(result)
}
