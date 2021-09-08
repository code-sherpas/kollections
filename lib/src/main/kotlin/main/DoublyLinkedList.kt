package main


/**
 * https://en.wikipedia.org/wiki/Linked_list
 */
class DoublyLinkedList<E> {

    private var first: Node<E>? = null
    private var last: Node<E>? = null

    var size: Int = 0
        private set

    fun get(index: Int): E {
        if(index < 0 || index >= size) TODO()

        return when (index) {
            0 -> first!!.value
            else -> TODO()
        }
    }

    fun isEmpty(): Boolean = size == 0

    /**
     * Adds the specified element to the end of this list.
     */
    fun addLast(element: E) = Unit.also {
        Node(element).let { newNode: Node<E> ->
            when (this.isEmpty()) {
                true -> insertionOnEmptyList(newNode)
                false -> {
                    last!!.next = newNode
                    newNode.previous = last
                    last = newNode
                }
            }
        }
    }.also { incrementSize() }

    /**
     * Adds the specified element to the beginning of this list.
     */
    fun addFirst(element: E) = Unit.also {
        Node(element).let { newNode: Node<E> ->
            when (this.isEmpty()) {
                true -> insertionOnEmptyList(newNode)
                false -> {
                    newNode.next = first
                    first!!.previous = newNode
                    first = newNode
                }
            }
        }
    }.also { incrementSize() }

    fun tail(): DoublyLinkedList<E> {
        TODO("Review implementation")
        /*
        if(size < 2) TODO("Not yet implemented")

        val tail = DoublyLinkedList<E>()
        tail.first = this.first!!.next
        tail.last = this.last
        tail.size = this.size - 1
        return tail
         */
    }

    fun head(): E {
        if(isEmpty()) throw NoSuchElementException()

        return first!!.value
    }

    private fun incrementSize() {
        size++
    }

    private fun insertionOnEmptyList(newNode: Node<E>) {
        last = newNode
        first = last
    }

    private class Node<E>(value: E) {
        var value: E = value
            private set
        var previous: Node<E>? = null
        var next: Node<E>? = null
    }

}
