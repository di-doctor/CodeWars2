fun main() {
    println(gap(2, 3, 10).toList())
    println(gap2(2, 3, 10).toList())


}

fun gap2(g: Int, m: Long, n: Long): LongArray {
    (m..n).forEach {
        val firstValue = it
        val lastValue = it + g.toLong()
        val listWithOutFirstAndLast = (firstValue..lastValue).drop(1).dropLast(1)
        if (isSimpleNumber(firstValue)
            && isSimpleNumber(lastValue)
            && listWithOutFirstAndLast.map { num -> isSimpleNumber(num) }.none() { value -> value }
        ) return longArrayOf(firstValue, lastValue)
        else return@forEach
    }
    return LongArray(0)
}

fun gap(g: Int, m: Long, n: Long): LongArray {
    val listOfWindow = (m..n).toList().windowed(g + 1)


    for (list in listOfWindow) {
        val listBoolean: MutableList<Boolean> = mutableListOf()
        val startValue = list.first()
        val lastValue = list.last()
        val isStartValueSimple = isSimpleNumber(startValue)
        val isLastValueSimple = isSimpleNumber(lastValue)
        val listDropStartEnd = list.drop(1).dropLast(1)
        listDropStartEnd.forEach {
            listBoolean.add(isSimpleNumber(it))
        }
        val allListBoolean = listBoolean.all { !it }
        if (isStartValueSimple && isLastValueSimple && allListBoolean) {
            return longArrayOf(startValue, lastValue)
        }
    }

    return LongArray(0)
}

fun isSimpleNumber(value: Long): Boolean {
    if (value == 0L) return false
    var flag = true
    for (i in 2..value / 2) {
        if (value % i == 0L) {
            flag = false
            break
        }
    }
    return flag
}

/*
fun main(args: Array)
( val num = 29 var flag = false for (i in 2… num / 2)
        ( // condition for nonprime number if (num % i == 0) ( flag = true break ) )
// if (!flag) println("$num is a prime number.") else println("$num is not a prime number.") )*/
