package main

import org.assertj.core.api.Assertions
import java.time.ZonedDateTime
import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.test.Test


internal class StackTest {

    @Test
    fun `push & pop performance`() {

        val times = 20500000

        val stack: Stack<Int> = Stack()

        val implementationTime = measureTimeMillis {
            repeat(10) {
                repeat(times) {
                    stack.push(Random(ZonedDateTime.now().nano).nextInt())
                }
                repeat(times) {
                    stack.pop()
                }
            }
        }

        val javaStack: java.util.Stack<Int> = java.util.Stack<Int>()
        val javaImplementationTime = measureTimeMillis {
            repeat(10) {
                repeat(times) {
                    javaStack.push(Random(ZonedDateTime.now().nano).nextInt())
                }
                repeat(times) {
                    javaStack.pop()
                }
            }
        }

        if (implementationTime > javaImplementationTime * 0.95) Assertions.fail<Unit>(
            "Own implementation time: $implementationTime ms\n" +
                    "Java implementation time: $javaImplementationTime ms"
        )
    }
}