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
    

    //Head and tail node of the SLL
    var head : Node?= null
    var tail : Node?= null

    
    //Checks if SLL is empty 
    fun isEmpty(): Boolean{
        return head == null
    }


    //Returns value of head element
    fun head(): E?{
        return this.head?.value
    }

    //Insert element at the head of SLL
    fun insertAtBeginning(element: E){
        if (this.isEmpty()){
            var newNode = Node(element)
            this.head = newNode
            this.tail = newNode
            return
        }
        else{ 
            var newNode = Node(element)
            newNode.next = this.head
            this.head = newNode
            return
        }
    }
}