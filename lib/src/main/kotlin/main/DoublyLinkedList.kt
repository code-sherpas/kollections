package main


/**
 * https://en.wikipedia.org/wiki/Linked_list
 */
class DoublyLinkedList<E> : MutableList<E> {

    private class Node<E>(private var value: E) {
        var previous: Node<E>? = null
        var next: Node<E>? = null
    }

    private var first: Node<E>? = null
    private var last: Node<E>? = null

    override var size: Int = 0
        private set
        get() = TODO()

    override fun contains(element: E): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<E>): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(index: Int): E {
        TODO("Not yet implemented")
    }

    override fun indexOf(element: E): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<E> {
        TODO("Not yet implemented")
    }

    override fun lastIndexOf(element: E): Int {
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
    }

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
    }

    private fun insertionOnEmptyList(newNode: Node<E>) {
        last = newNode
        first = last
    }

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

    override fun listIterator(): MutableListIterator<E> {
        TODO("Not yet implemented")
    }

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
}