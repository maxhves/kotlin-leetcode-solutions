package hackerrank.easy

private fun designerPdfViewer(h: Array<Int>, word: String): Int {
    val heights = IntArray(word.length)

    for ((i, x) in word.withIndex()) {
        heights[i] = h[x - 'a']
    }

    return heights.max() * word.length
}

private fun main(args: Array<String>) {

    val h = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val word = readLine()!!

    val result = designerPdfViewer(h, word)

    println(result)
}