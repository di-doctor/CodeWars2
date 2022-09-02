import kotlin.math.pow

fun main() {
    println(isSumOfCubes("aqdf&0#1xyz!22[153(777.7774sd5643"))
    println()
    println(isSumOfCubes("Once 1000upon a midnight 110dreary, while100 I pondered, 9026315weak and weary -827&()"))


}

fun movie(card: Int, ticket: Int, perc: Double): Int {
    var total: Double = card.toDouble()
    var lastItem = ticket * perc
    var count = 1

    while (ticket * count <= Math.round(total + lastItem)) {
        lastItem *= perc
        total += lastItem
        total = Math.ceil(total).toDouble()
        count++
    }
    return count
}

fun twoSum(numbers: IntArray, target: Int): Pair<Int, Int> {
    for (indexOut in numbers.indices) {
        for (indexIn in (indexOut + 1) until numbers.size)
            if (numbers[indexOut] + numbers[indexIn] == target) {
                return Pair(indexOut, indexIn)
            }
    }
    throw Exception("Нет такого массива который удовлетворяет нашим условиям")
}

fun isSumOfCubes(s: String): String {


    val listOfIsCubic = s.split(Regex("\\D"))
        .filter (predicate = String::isNotEmpty)//.also { println(it) }
        .flatMap { it.chunked(3) }//.also ( block = ::println )
        .filter(predicate = lamdaIsCubic)//.also { println(it) }
        .map (transform = String::myParseInt)

    val sum = listOfIsCubic.sumOf { it }

    return if (listOfIsCubic.isNotEmpty()) {
        listOfIsCubic.joinToString(" ") + " $sum" + " Lucky"
    } else "Unlucky"
}

fun String.isCubic(): Boolean {
    val number = this.toInt()
    val sum =
        this.sumOf { char -> "$char".toDouble().pow(3.0) }.toInt()
    return number == sum
}

fun isCubicUp(str: String): Boolean {
    val number = str.toInt()
    val sum =
        str.sumOf { char -> "$char".toDouble().pow(3.0) }.toInt()
    return number == sum
}


val lamdaIsCubic = { str: String ->
    val number = str.toInt()
    val sum =
        str.sumOf { char: Char -> "$char".toDouble().pow(3.0) }.toInt()
    number == sum
}

fun String.myParseInt(): Int{
    return Integer.parseInt(this)
}

