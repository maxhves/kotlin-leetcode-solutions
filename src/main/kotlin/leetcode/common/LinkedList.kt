package leetcode.common

class LinkedList(
    vararg nodeValues: Int,
) {
    private val dummyNode = ListNode(0)
    val head: ListNode?
        get() = dummyNode.next

    init {
        var current: ListNode? = dummyNode

        for (value in nodeValues) {
            current?.next = ListNode(value)
            current = current?.next
        }
    }
}