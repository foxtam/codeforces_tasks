fun main() {
    readLine()
    val count = readLine()!!.run { length - 2 * count { it == '0' } }
    println(kotlin.math.abs(count))
}