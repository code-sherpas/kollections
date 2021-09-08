package main

/**
 * https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */
class Stack<E> {
    private val dynamicArray = DynamicArray<E>()

    val size: Int
        get() = dynamicArray.size

    fun push(element: E) {
        dynamicArray.add(element)
    }

    fun pop(): E = dynamicArray.removeAt(dynamicArray.lastIndex)

    fun isEmpty(): Boolean = dynamicArray.isEmpty()
}
