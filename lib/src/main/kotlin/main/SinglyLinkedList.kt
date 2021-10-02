package main

/**
 * https://en.wikipedia.org/wiki/Linked_list
 *
 */

class SinglyLinkedList<E>{
    //Class representing each node of the SLL       
    inner class Node(var value: E){
            var next: Node?= null
    }
    
    //Head node of the SLL
    var head : Node?= null
    
    //Checks if SLL is empty 
    fun isEmpty(): Boolean{
        return head == null
    }
}