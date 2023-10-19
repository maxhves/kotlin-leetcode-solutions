package hackerrank.easy

import java.lang.Math.abs
import java.util.*

private fun catAndMouse(x: Int, y: Int, z: Int): String {
    // x: Cat A
    // y: Cat B
    // z: Mouse C
    val catADiff = abs(x - z)
    val catBDiff = abs(y - z)

    return if (catADiff == catBDiff) {
        "Mouse C"
    } else if (catADiff < catBDiff) {
        "Cat A"
    } else {
        "Cat B"
    }
}

private fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val xyz = scan.nextLine().split(" ")

        val x = xyz[0].trim().toInt()

        val y = xyz[1].trim().toInt()

        val z = xyz[2].trim().toInt()

        val result = catAndMouse(x, y, z)

        println(result)
    }
}