package main

/**
 * https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */
class Stack<E> {
    private val elements: MutableList<E> = mutableListOf()

    fun push(element: E) = elements.add(element)

    fun isEmpty() = elements.isEmpty()

    fun peek() = elements.lastOrNull()

    fun size() = elements.size
}
