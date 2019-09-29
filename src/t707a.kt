
fun main() {
    val (n, _) = readLine()!!.split(' ').map(String::toInt)
    repeat(n) {
        if (readLine()!!.any { it in "CYM" }) {
            println("#Color")
            return
        }
    }
    println("#Black&White")
}