fun <T> transpose(table: List<List<T>>): List<List<T>> {
    val minSize = table.map { it.size }.min() ?: 0
    return List(minSize) { i -> table.map { it[i] } }
}

fun main(args: Array<String>) {
    readLine()
    val nums = readLine()!!
        .split(' ')
        .map { it.toInt() }
    val initMap = mutableMapOf(1 to mutableListOf<Int>(), 2 to mutableListOf(), 3 to mutableListOf())
    val groups = nums.withIndex()
        .groupByTo(initMap, { it.value }, { it.index + 1 })
    val commands = transpose(groups.values.toList())
    println(commands.size)
    commands
        .map { it.joinToString(separator = " ") }
        .forEach { println(it) }
}
