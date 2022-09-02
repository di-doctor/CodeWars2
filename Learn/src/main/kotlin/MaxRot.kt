import java.util.Collections.swap
import kotlin.random.Random

fun main() {

    val list = mutableListOf<Int>()
    repeat(50) {
        var size = 0

        try {
           readLine().apply {
                if (this == "exit") return
                size = this?.toInt() ?: 0
            }

        }
        catch (e: NumberFormatException){

            println("Введите число")
        }

        if (size == 1000) return
        val arr = Array(size) { Random.nextInt(0, 80) }
        println(arr.joinToString(" "))

    }


}


//println(arr.joinToString(" "))
//println(arr.size)

var list: List<Char> = listOf('2', '4', '9')
//println( list.joinToString ("").toInt())


fun maxRot(n: Long): Long {
    val listOfCharOfNumber: List<Char> = n.toString().toList()
    val listResult = mutableListOf<Long>()
    listResult.add(n)
    val lengthOfNumber = listOfCharOfNumber.size

    repeat(lengthOfNumber - 1) {

        for (index in it until lengthOfNumber - 1) {
            swap(listOfCharOfNumber, index, index + 1)

        }
        listResult.add(listOfCharOfNumber.joinToString("").toLong())

    }
    return listResult.maxOf { it }
}


