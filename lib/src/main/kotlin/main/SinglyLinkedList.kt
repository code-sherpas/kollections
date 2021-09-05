package main

/**
 * https://en.wikipedia.org/wiki/Linked_list
 *
 * TODO: try to use delegation (https://kotlinlang.org/docs/delegation.html)
 */

class SinglyLinkedList<E>(node: E) : MutableList<E> by DoublyLinkedList(node)