fun deltaCount(array: List<Int>): Int {
    fun findBoundZeroIndices(array: List<Int>) =
        array.mapIndexedNotNull { i, v ->
            i.takeIf { v == -1 && (i == 0 || array[i - 1] == 1) }
        }

    val zeroBeginIndices = findBoundZeroIndices(array)
    val zeroEndIndices =
        findBoundZeroIndices(array.reversed())
            .map { array.size - it - 1 }.reversed()

    var target = Triple(1, 0, 0)
    for (i in zeroBeginIndices)
        for (j in zeroEndIndices)
            if (i <= j) {
                val count = array.subList(i, j + 1).sum()
                if (count < target.first)
                    target = Triple(count, i, j)
            }
    val (_, left, right) = target

    return array
        .mapIndexed { i, v -> if (i in left..right) -v else v }
        .count { it == 1 }
}

fun main() {
    readLine()
    val array = readLine()!!.split(" ").map { it.toInt() * 2 - 1 }
    val count = deltaCount(array)
    println(count)
}