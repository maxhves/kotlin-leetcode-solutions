package hackerrank.easy

private fun countApplesAndOranges(
    s: Int, // House start
    t: Int, // House end
    a: Int, // Apple tree
    b: Int, // Orange tree
    apples: Array<Int>, // Apples that fall
    oranges: Array<Int>, // Oranges that fall
): Unit {
    // Apples: -n moves away from house, +n moves closer to house
    // Oranges: -n moves closes to house, +n moves away from house

    // Difference between apple tree and house start
    // Difference between orange tree and house end

    // aT: 1, hS: 3, hE: 4, oT: 6
    // if apple is > 1 && < 4
    // if orange is > -1 && < -4
    // Then the fruit will touch the house

    // Count the apples
    var appleInHouseCount = 0

    // Loop through the apples array
    for (apple in apples) {
        // Check the apples that are in the house
        if (apple >= (s - a) && apple <= (t - a)) {
            appleInHouseCount++
        }
    }

    // Do the same for oranges
    var orangeInHouseCount = 0

    for (orange in oranges) {
        if (orange <= (t - b) && orange >= (s - b)) {
            orangeInHouseCount++
        }
    }

    println(appleInHouseCount)
    println(orangeInHouseCount)
}

private fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val s = first_multiple_input[0].toInt()

    val t = first_multiple_input[1].toInt()

    val second_multiple_input = readLine()!!.trimEnd().split(" ")

    val a = second_multiple_input[0].toInt()

    val b = second_multiple_input[1].toInt()

    val third_multiple_input = readLine()!!.trimEnd().split(" ")

    val m = third_multiple_input[0].toInt()

    val n = third_multiple_input[1].toInt()

    val apples = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val oranges = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    countApplesAndOranges(s, t, a, b, apples, oranges)
}