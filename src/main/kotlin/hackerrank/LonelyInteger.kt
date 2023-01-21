package hackerrank

fun lonelyinteger(a: Array<Int>): Int {
    // Problem
    // Given an array of integers, where
    // - All elements but one occur twice
    //
    // Find the unique element

    // Basic solution
    val array = mutableListOf<Int>()

    for (element in a) {
        if (array.contains(element)) {
            array.remove(element)
        } else {
            array.add(element)
        }
    }

    return array[0]
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = lonelyinteger(a)

    println(result)
}