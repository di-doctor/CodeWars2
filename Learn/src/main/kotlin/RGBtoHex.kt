fun main() {
    println(rgb2(-23, 123, 455))

}


fun rgb2(r: Int, g: Int, b: Int): String = listOf(r, g, b).joinToString("") {
         round(it)
        .toString(16)
        .padStart(2, '0')
        .toUpperCase()
}


fun round(value: Int): Int = when {
    value < 0 -> 0
    value > 255 -> 255

    else -> value
}

