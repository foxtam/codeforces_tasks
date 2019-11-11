fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val a = readLine()!!.toInt()
        println(if (360 % (180 - a) == 0) "YES" else "NO")
    }
    
}
