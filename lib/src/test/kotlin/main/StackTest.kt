package main

import org.assertj.core.api.Assertions.assertThat
import java.time.ZonedDateTime
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.test.Ignore
import kotlin.test.Test


internal class StackTest {

    @Ignore
    @Test fun benchmark() {

        val times = 20500000
        val javaStack: java.util.Stack<Int> = java.util.Stack<Int>()
        val javaImplementationTime = measureTimeMillis {
            repeat(times) {
                javaStack.push(Random(ZonedDateTime.now().nano).nextInt())
            }
            repeat(times) {
                javaStack.pop()
            }
        }

        val stack: Stack<Int> = Stack<Int>()
        val implementationTime = measureTimeMillis {
            repeat(times) {
                stack.push(Random(ZonedDateTime.now().nano).nextInt())
            }
            repeat(times) {
                stack.pop()
            }
        }

        assertThat(implementationTime).isLessThan(javaImplementationTime)
    }
}