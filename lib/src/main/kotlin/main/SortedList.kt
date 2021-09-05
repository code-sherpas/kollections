package main

import java.io.Serializable

class SortedList<T : Comparable<T>> : AbstractMutableCollection<T>(), List<T>, RandomAccess, Cloneable, Serializable {

    override val size: Int
        get() = internalList.size

    override fun get(index: Int): T = internalList[index]

    private val internalList: ArrayList<T> = ArrayList()

    override fun iterator(): MutableIterator<T> = internalList.iterator()

    override fun add(element: T): Boolean = internalList.binarySearch(element = element).let { result ->
        when {
            result >= 0 -> internalList.add(index = result, element = element)
            else -> internalList.add(index = -result - 1, element = element)
        }.let { true }
    }

    override fun indexOf(element: T): Int = internalList.indexOf(element)

    override fun lastIndexOf(element: T): Int = internalList.lastIndexOf(element)

    override fun listIterator(): ListIterator<T> = internalList.listIterator()

    override fun listIterator(index: Int): ListIterator<T> = internalList.listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): List<T> = internalList.subList(
        fromIndex = fromIndex,
        toIndex = toIndex
    )

    override fun remove(element: T): Boolean = internalList.binarySearch(element = element).let { result ->
        when {
            result >= 0 -> internalList.removeAt(result).let { true }
            else -> false
        }
    }

    override fun addAll(elements: Collection<T>): Boolean {
        val previousSize = this.size
        elements.forEach { element -> this.add(element) }
        return previousSize != this.size
    }

    override fun contains(element: T): Boolean = internalList.binarySearch(element).let {
        when {
            it >= 0 -> true
            else -> false
        }
    }

    override fun containsAll(elements: Collection<T>): Boolean = elements.all { this.contains(it) }

    override fun removeAll(elements: Collection<T>): Boolean {
        val previousSize = this.size
        elements.forEach { element -> this.remove(element) }
        return previousSize != this.size
    }

    override fun retainAll(elements: Collection<T>): Boolean = internalList.removeIf { !elements.contains(it) }
}