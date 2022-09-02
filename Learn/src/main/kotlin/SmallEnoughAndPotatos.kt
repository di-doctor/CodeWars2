import kotlin.math.roundToInt

fun main() {
    println(evaporator(100.0, 5.0, 5.0))
}

fun smallEnough(a: IntArray, limit: Int) = a.all { it <= limit }

fun potatoes(p0: Int, w0: Int, p1: Int): Int {
    return (w0 * (1 - p0 / 100.0) / (1 - p1 / 100.0)).roundToInt()
}

fun evaporator(content: Double, evap_per_day: Double, threshold: Double): Int {
    var capacity = content
    var countDay: Int = 0

    fun count(c: Double) {
        if (c > threshold * 0.01) {
            countDay++
            count(c - c * evap_per_day * 0.01)
        }
    }
    count(content)
    return countDay
}
