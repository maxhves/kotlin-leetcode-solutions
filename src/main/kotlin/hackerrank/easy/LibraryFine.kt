package hackerrank.easy

private fun libraryFine(d1: Int, m1: Int, y1: Int, d2: Int, m2: Int, y2: Int): Int {
    // If return year is bigger than the due year
    return if (y1 > y2) {
        10000

    // If the years are the same AND the month of return is bigger than the due month
    } else if (y2 == y1 && m1 > m2) {
        500 * (m1 - m2)

    // If the years and months are the same AND the day is return bigger than the due day
    } else if (y2 == y1 && m2 == m1 && d1 > d2) {
        15 * (d1 - d2)

    // It's arrived at or before the due date
    } else {
        0
    }
}

private fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val d1 = first_multiple_input[0].toInt()

    val m1 = first_multiple_input[1].toInt()

    val y1 = first_multiple_input[2].toInt()

    val second_multiple_input = readLine()!!.trimEnd().split(" ")

    val d2 = second_multiple_input[0].toInt()

    val m2 = second_multiple_input[1].toInt()

    val y2 = second_multiple_input[2].toInt()

    val result = libraryFine(d1, m1, y1, d2, m2, y2)

    println(result)
}