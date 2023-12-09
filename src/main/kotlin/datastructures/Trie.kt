package datastructures

class Trie(
    private val root: TrieNode,
) {
    fun insert(word: String) {
        var currentNode = root

        for (char in word) {
            if (char !in currentNode.children) {
                currentNode.children[char] = TrieNode()
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }
        currentNode.isWord = true
    }

    fun search(word: String): Boolean {
        var currentNode = root

        for (char in word) {
            if (char !in currentNode.children) {
                return false
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }
        return currentNode.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var currentNode = root

        for (char in prefix) {
            if (char !in currentNode.children) {
                return false
            }
            currentNode = currentNode.children.getOrDefault(char, TrieNode())
        }
        return true
    }
}