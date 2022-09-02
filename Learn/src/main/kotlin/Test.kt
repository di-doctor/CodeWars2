import kotlin.random.Random

fun main() {
    var dany: Int = 0
    var dima: Int = 0
    val myArray = Array(20) { Random.nextInt(0, 101) }
    println(myArray.contentToString())

    val pair = myArray.partition { it < 33 }

    println(pair.first.joinToString())
    println(pair.second.joinToString())


    pair.first.count().also { println(" количество случайных чисел меньше  -- $it") }
    pair.second.count().also { println(" количество случайных  больше  -- $it") }

}