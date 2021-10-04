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

    //Returns value of tail element
    fun tail(): E?{
        return this.tail?.value
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

    //Insert element at the end/tail of the SLL
    fun insertAtEnd(element: E) {
        if (this.isEmpty()){
            var newNode = Node(value = element)
            this.head = newNode
            this.tail = newNode
            return
        }

        tail?.next = Node(value = element)
        tail = tail?.next
    }

    //get the node at a particular index (helper function)
    fun nodeAtIndex(index: Int) : Node? {
        if (index >= 0) {
            var node = head
            var i = index
            while (node != null) {
                if (i == 0) return node
                i -= 1
                node = node.next
            }
        }
        return null
    }

    //remove node at particular position
    fun deleteNode(position: Int) {
        val node = nodeAtIndex(position)
        if (node != null) {
            val prev = nodeAtIndex(position-1)
            val next = node.next
            if (prev != null) {
                prev.next = next
            } else {
                head = next
            }
            node.next = null
            return
        }
        return
        
    }
}