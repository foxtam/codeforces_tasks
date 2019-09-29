import kotlin.math.*

fun is2Pow(n: Double): Boolean = 2.0.pow(log2(n).toInt()) == n

fun cut(n: Double): Int = when {
    is2Pow(n) -> 1
    n % 2 == 1.0 -> 1 + cut((n - 1) / 2)
    else -> cut(n / 2)
}

fun main() {
    val n = readLine()!!.toDouble()
    println(cut(n))
}