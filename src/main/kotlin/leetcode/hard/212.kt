package leetcode.hard

//region Problem

/**
 * Given an (m x n) (board) of characters and a list of strings (words), return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent celts, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once in
 * a word.
 */

//endregion

//region Steps to solve

/**
 * Steps
 * -
 */

//endregion

//region Solution

private fun main() {
    findWords(
        board = arrayOf(
            charArrayOf('o', 'a', 'a', 'n'),
            charArrayOf('e', 't', 'a', 'e'),
            charArrayOf('i', 'h', 'k', 'r'),
            charArrayOf('i', 'f', 'l', 'v'),
        ),
        words = arrayOf("oath", "pea", "eat", "rain"),
    )
}

private class TrieNode {
    val children = HashMap<Char, TrieNode>(26)
}

private fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val trie = TrieNode()
    val rows = board.size
    val columns = board[0].size

    for (row in 0 until rows) {
        for (column in 0 until columns) {
            val centerItem = board[row][column]
            trie.children[centerItem] = TrieNode()
        }
    }

    return listOf()
}

//endregion
