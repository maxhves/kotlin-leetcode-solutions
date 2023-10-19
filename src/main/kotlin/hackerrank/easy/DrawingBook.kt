package hackerrank.easy

private fun pageCount(n: Int, p: Int): Int {
    // n: Number of pages
    // p: Page to go to
    return if (p > (n / 2 )) {
        ((n / 2) - (p / 2))
    } else {
        p / 2
    }
}

private fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val p = readLine()!!.trim().toInt()

    val result = pageCount(n, p)

    println(result)
}