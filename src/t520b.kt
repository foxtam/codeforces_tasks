import java.util.*

import kotlin.system.measureTimeMillis

fun closeTo(n: Int, m: Int): Int {
    val queue: Queue<Pair<Int, Int>> = ArrayDeque(listOf(n to 0))
    val unique = mutableSetOf(n)
    while (true) {
        val (value, count) = queue.remove()
        if (value == m) return count
        else {
            if (value < m && (value * 2) !in unique) {
                queue.offer(value * 2 to count + 1)
                unique.add(value * 2)
            }
            if (value - 1 > 0 && (value - 1) !in unique) {
                queue.offer(value - 1 to count + 1)
                unique.add(value - 1)
            }
        }
    }
}

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    measureTimeMillis {
        println("${closeTo(n, m)}")
    }.let(::println)
}