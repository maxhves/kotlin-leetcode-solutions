package hackerrank

import java.util.PriorityQueue

// Initial solution
// Unfortunately solution is too slow...
fun cookies(k: Int, A: Array<Int>): Int {
    // sweetness = (1 * least sweet cookie + 2 * 2nd least sweet cookie)

    // Case
    // k = 9
    // A = [2, 7, 3, 6, 4, 6]

    // Iterate through the array
    // Get the two smallest items
    // Combine them
    // Check if all items are bigger than the limit
    // Iterate through the array
    // ..etc
    A.sort()
    val cookies = A.toMutableList()
    var numOfOperations = 0

    while (cookies.size != 1) {
        val cookieOne = cookies[0]
        val cookieTwo = cookies[1]

        if (cookieOne >= k && cookieTwo >= k) {
            return numOfOperations
        } else {
            cookies.removeAt(0)
            cookies.removeAt(0)
            cookies.add(cookieOne + (cookieTwo * 2))
            cookies.sort()
            numOfOperations++
        }
    }

    return -1
}

// Better solution
fun cookies2(k: Int, A: Array<Int>): Int {
    val sortedQueue = PriorityQueue<Int>()
    sortedQueue.addAll(A)

    var numberOfOperations = 0

    while (sortedQueue.peek() < k) {
        numberOfOperations++

        if (sortedQueue.size == 1) return -1

        val cookieOne = sortedQueue.poll()
        val cookieTwo = sortedQueue.poll()
        val newCookie = cookieOne + (cookieTwo * 2)

        sortedQueue.add(newCookie)
    }

    return numberOfOperations
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val k = first_multiple_input[1].toInt()

    val A = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = cookies2(k, A)

    println(result)
}