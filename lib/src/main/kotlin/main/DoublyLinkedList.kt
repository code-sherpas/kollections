package main


/**
 * https://en.wikipedia.org/wiki/Linked_list
 */
class DoublyLinkedList<E> : AbstractMutableList<E>() {

    private var first: Node<E>? = null
    private var last: Node<E>? = null

    override var size: Int = 0
        private set

    override fun get(index: Int): E {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<E> {
        TODO("Not yet implemented")
    }

    override fun add(element: E): Boolean = true.also {
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
     *
     * @return `true` because the list is always modified as the result of this operation.
     */
    fun addFirst(element: E): Boolean = true.also {
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

    override fun add(index: Int, element: E) {
        TODO("Not yet implemented")
    }

    override fun addAll(index: Int, elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun listIterator(): MutableListIterator<E> = ListIterator()

    override fun listIterator(index: Int): MutableListIterator<E> {
        TODO("Not yet implemented")
    }

    override fun remove(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAt(index: Int): E {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun set(index: Int, element: E): E {
        TODO("Not yet implemented")
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> {
        TODO("Not yet implemented")
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
