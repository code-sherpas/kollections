package main

/**
 * https://en.wikipedia.org/wiki/Linked_list
 */
class DoublyLinkedList<E> : MutableList<E> {

    private var first: DoublyLinkedList<E>? = null
    private var last: DoublyLinkedList<E>? = null

    private var value: E? = null
    private var previous: DoublyLinkedList<E>? = null
    private var next: DoublyLinkedList<E>? = null

    override val size: Int
        get() = 1 + (previous?.size ?: 0) + (next?.size ?: 0)

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

    override fun add(element: E): Boolean {
        when(value) {
            null -> value = element
            else -> {
                next = DoublyLinkedList<E>().apply { value = element }
                next!!.previous = this
            }
        }
        return true
    }

    /**
     * Adds the specified element to the beginning of this list.
     *
     * @return `true` because the list is always modified as the result of this operation.
     */
    fun addFirst(element: E): Boolean {
        previous = DoublyLinkedList(element)
        previous!!.next = this
        return true
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