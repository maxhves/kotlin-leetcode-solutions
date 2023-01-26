package hackerrank.easy

import java.math.BigInteger

fun taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Long {
    // b: number of b gifts
    // w: number of w gifts
    // bc: cost of b
    // wc: cost of w
    // z: cost to convert one color to the other
    // Return minimum costs
    val bCost = bc.toLong()
    val wCost = wc.toLong()
    val bSwapCost = (bCost + z.toLong())
    val wSwapCost = (wCost + z.toLong())

    val bCs = minOf(bCost, wSwapCost)
    val wCs = minOf(wCost, bSwapCost)

    return (bCs * b) + (wCs * w)
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val first_multiple_input = readLine()!!.trimEnd().split(" ")

        val b = first_multiple_input[0].toInt()

        val w = first_multiple_input[1].toInt()

        val second_multiple_input = readLine()!!.trimEnd().split(" ")

        val bc = second_multiple_input[0].toInt()

        val wc = second_multiple_input[1].toInt()

        val z = second_multiple_input[2].toInt()

        val result = taumBday(b, w, bc, wc, z)

        println(result)
    }
}