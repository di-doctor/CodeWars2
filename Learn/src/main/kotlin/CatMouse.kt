fun main() {
    val array = intArrayOf()
    println(invert(array).joinToString (" "))
}


fun evenNumbers(array: List<Int>, number: Int): List<Int> {
    return array.filter { it % 2 == 0 }
        .takeLast(number)
}

fun invert(arr: IntArray): IntArray {
    if (arr.isEmpty()) return emptyArray<Int>().toIntArray()
     return arr.map { it * (-1) }.toIntArray()
}



