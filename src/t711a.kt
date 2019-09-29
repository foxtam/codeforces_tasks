fun main() {
    val n = readLine()!!.toInt()
    val seats = MutableList(n) { readLine()!! }
    val i = seats.indexOfFirst { "OO" in it }
    if (i != -1) {
        seats[i] = seats[i].replaceFirst("OO", "++")
        println("YES")
        seats.forEach(::println)
    } else {
        println("NO")
    }
}