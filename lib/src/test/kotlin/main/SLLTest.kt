package main

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import main.SinglyLinkedList

class SLLTest {
   
    
    var SLL: SinglyLinkedList<Int> = SinglyLinkedList<Int>()

    @Test
    fun checkIsEmpty() {
        assertThat(SLL.isEmpty()).isTrue
    }
}