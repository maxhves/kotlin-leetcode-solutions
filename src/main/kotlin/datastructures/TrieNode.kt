package datastructures

class TrieNode {
    val children: HashMap<Char, TrieNode> = HashMap(26)
    var isWord: Boolean = false
}