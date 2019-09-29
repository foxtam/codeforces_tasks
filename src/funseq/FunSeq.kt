package funseq

private typealias Sq<T> = Sequence<T>

data class HeadTail<T>(val head: T, val tail: Sq<T>)

fun <T> Sq<T>.detach(): HeadTail<T> = HeadTail(head, tail)

infix fun <T> T.extend(tail: Sq<T>): Sq<T> =
    sequence {
        yield(this@extend)
        yieldAll(tail)
    }

infix fun <T> Sq<T>.extend(tail: Sq<T>): Sq<T> =
    sequence {
        yieldAll(this@extend)
        yieldAll(tail)
    }

val <T> Sq<T>.head: T
    get() = first()

val <T> Sq<T>.tail: Sq<T>
    get() = drop(1)

tailrec infix fun <T> Sq<T>.eqRec(ys: Sq<T>): Boolean =
    when {
        none() && ys.none() -> true
        none() || ys.none() || head != ys.head -> false
        else -> tail eqRec ys.tail
    }

infix fun <T> Sq<T>.eq(ys: Sq<T>): Boolean {
    val iter1 = iterator()
    val iter2 = ys.iterator()
    while (iter1.hasNext() && iter2.hasNext()) {
        if (iter1.next() != iter2.next())
            return false
    }
    if (iter1.hasNext() || iter2.hasNext())
        return false
    return true
}

fun <T> Sq<T>.reversed(): Sq<T> = toMutableList().apply { reverse() }.asSequence()