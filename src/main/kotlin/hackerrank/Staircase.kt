package hackerrank

import java.util.*

// Initial
fun staircase(n: Int): Unit {
    for (i in 1..n) {
        val chars = CharArray(n) { index ->
            if (i >= (n -index)) {
                '#'
            } else {
                ' '
            }
        }
        println(chars.joinToString(""))
    }
}

// Better
fun staircase2(n: Int): Unit {
    // For each count until n
    for (i in 1..n) {
        // Print " " repeated by (n - i) and then "#" by (i)
        println(" ".repeat(n - i) + "#".repeat(i))
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    staircase2(n)
}