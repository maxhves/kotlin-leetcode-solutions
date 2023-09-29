package leetcode.easy

//region Problem

/**
 * There is a stream of `n` `(idKey, value)` pairs arriving in an arbitrary order, where `idKey` is an integer
 * between `1` and `n` and `value` is a string. No two pairs have the same `id`.
 *
 * Design a stream that returns the values in increasing order of their IDs by returning a chunk (list) of values
 * after each insertion. The concatenation of all the chunks should result in a list of the sorted values.
 *
 * Implement the `OrderedStream` class:
 * - `OrderedStream(int n)` Constructs the stream to take `n` values.
 * - `String[] insert(int idKey, String value)` Inserts the paid `(idKey value)` into the stream, then returns the
 *   largest possible chunk of currently inserted values that appear next in the order.
 */

//endregion

//region Test cases

/**
 *
 */

//endregion

//region Solution

private fun main() {
    val orderedStream = OrderedStream(n = 5)
    println(orderedStream.insert(3, "ccccc").joinToString())
    println(orderedStream.insert(1, "aaaaa").joinToString())
    println(orderedStream.insert(2, "bbbbb").joinToString())
    println(orderedStream.insert(5, "eeeee").joinToString())
    println(orderedStream.insert(4, "ddddd").joinToString())
}

class OrderedStream(val n: Int) {
    private val hashMap = HashMap<Int, String>()
    private var pointer: Int = 1

    fun insert(idKey: Int, value: String): List<String> {
        hashMap[idKey] = value
        val result = ArrayList<String>()

        var itemToFind = hashMap.getOrDefault(pointer, null)

        while(itemToFind != null) {
            result.add(itemToFind)
            hashMap.remove(pointer)
            pointer++
            itemToFind = hashMap.getOrDefault(pointer, null)
        }

        return result
    }
}

//endregion