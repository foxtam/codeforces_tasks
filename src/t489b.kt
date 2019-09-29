import funseq.*

fun countPairs(boys: Sequence<Int>, girls: Sequence<Int>): Int =
    if (boys.none() || girls.none()) 0
    else (girls.head - boys.head).let {
        when {
            it < -1 -> countPairs(boys, girls.tail)
            it > 1 -> countPairs(boys.tail, girls)
            else -> 1 + countPairs(boys.tail, girls.tail)
        }
    }

fun main(args: Array<String>) {
    readLine()
    val boysLvl = readLine()!!
        .split(" ").map { it.toInt() }
    readLine()
    val girlsLvl = readLine()!!
        .split(" ").map { it.toInt() }
    countPairs(boysLvl.sorted().asSequence(), girlsLvl.sorted().asSequence())
        .let(::println)
}
