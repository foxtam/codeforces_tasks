fun tableMaximum(n: Int): Int {
    val matrix = IntArray(n * n) { 1 }

    for (i in 1 until n) {
        for (j in 1 until n) {
            matrix[i * n + j] = matrix[(i - 1) * n + j] + matrix[i * n + j - 1]
        }
    }
    return matrix[n * n - 1]
}

fun tableMax(n: Int): Int {
    fun inner(i: Int, j: Int): Int =
        if (i == 1 || j == 1) 1
        else inner(i - 1, j) + inner(i, j - 1)
    return inner(n, n)
}

fun main(args: Array<String>) {
    println(tableMaximum(readLine()!!.toInt()))
}
