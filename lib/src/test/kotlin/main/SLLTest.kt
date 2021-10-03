package main

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import main.SinglyLinkedList

class SLLTest {
     
    @Test
    fun checkInsertAtBeginning() {
        var SLL: SinglyLinkedList<Int> = SinglyLinkedList<Int>()
        assertThat(SLL.isEmpty()).isTrue
        assertThat(SLL.head()).isEqualTo(null)
        for (i in 1..10) {
            val randomInt = (0..10).random()
            SLL.insertAtBeginning(randomInt)
            assertThat(SLL.head()).isEqualTo(randomInt)
            assertThat(SLL.isEmpty()).isFalse
        }
    }

    fun checkInsertAtEnd() {
        var SLL: SinglyLinkedList<Int> = SinglyLinkedList<Int>()
        assertThat(SLL.isEmpty()).isTrue
        assertThat(SLL.head()).isEqualTo(null)
        for (i in 1..10) {
            val randomInt = (0..10).random()
            SLL.insertAtEnd(randomInt)
            assertThat(SLL.head()).isEqualTo(randomInt)
            assertThat(SLL.isEmpty()).isFalse
        }
    }
}