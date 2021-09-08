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
        TODO("Not yet implemented")
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

    override fun listIterator(): MutableListIterator<E> = ListIterator()

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

    private inner class ListIterator : MutableListIterator<E> {

        private var currentNode: Node<E>? = first
        private var index: Int = 0

        override fun hasPrevious(): Boolean = currentNode?.previous != null

        override fun nextIndex(): Int = index + 1

        override fun previous(): E {
            if (!hasPrevious()) throw NoSuchElementException()

            val value = currentNode!!.value
            currentNode = currentNode?.previous
            index--
            return value
        }

        override fun previousIndex(): Int = index - 1

        override fun add(element: E) {
            TODO("Not yet implemented")
        }

        override fun hasNext(): Boolean = currentNode?.next != null

        override fun next(): E {
            if (!hasNext()) throw NoSuchElementException()

            val value = currentNode!!.value
            currentNode = currentNode?.next
            index++
            return value
        }

        override fun remove() {
            TODO("Not yet implemented")
        }

        override fun set(element: E) {
            TODO("Not yet implemented")
        }
    }
}
