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
 * - Using a Trie structure we can add each word into said structure.
 * - We should then iterate over each element on the board:
 *   - We should run a recursive function that will check if the element exists in our Trie.
 *   - We then need to check the next position in all directions (apart from diagonally).
 *   - If we come across a char that doesn't exist we can immediately return false for this function.
 *   - If we reach a node that is a word, then we can add the current word to our result array.
 * - Ultimately, return the resulting words we have found.
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
    var isWord: Boolean = false
}

private fun findWords(
    board: Array<CharArray>,
    words: Array<String>,
): List<String> {
    val rows = board.size
    val columns = board[0].size
    val visited = Array(rows) { BooleanArray(columns) }
    val trie = TrieNode()

    val possibleWords = HashSet<String>()

    for (word in words) {
        var currentNode = trie

        for (char in word) {
            if (char !in currentNode.children) {
                currentNode.children[char] = TrieNode()
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }

        currentNode.isWord = true
    }

    fun dfs(
        row: Int,
        column: Int,
        currentNode: TrieNode,
        currentWord: String,
    ): Boolean {
        if (currentNode.isWord) {
            possibleWords.add(currentWord)
        }

        if (
            row < 0 ||
            column < 0 ||
            row >= rows ||
            column >= columns ||
            visited[row][column]
        ) {
            return false
        }

        val char = board[row][column]

        if (char !in currentNode.children) {
            return false
        }

        visited[row][column] = true

        val nextNode = currentNode.children.getOrDefault(char, TrieNode())
        val found = (
            dfs(row, column - 1, nextNode, "${currentWord}$char") ||
            dfs(row, column + 1, nextNode, "${currentWord}$char") ||
            dfs(row - 1, column, nextNode, "${currentWord}$char") ||
            dfs(row + 1, column, nextNode, "${currentWord}$char")
        )

        visited[row][column] = false

        return found
    }

    for (row in 0 until rows) {
        for (column in 0 until columns) {
            dfs(row, column, trie, "")
        }
    }

    return possibleWords.toList()
}

//endregion
