package test

import kotlin.math.pow
import kotlin.math.sqrt

fun meeting(s: String) = s.uppercase()
    .split(";").also { println(it) }
    .map { it.split(":") }.also { println(it) }
    .map { "(${it.last()}, ${it.first()})" }.also { println(it) }
    .sorted()
    .joinToString("")

fun meeting2(s: String) = s.uppercase()
    .split(";")
    .map { it.split(":") }
    .sortedWith(compareBy({ it[1] }, { it[0] })).also { println(it) }
    .joinToString(separator = ")(", prefix = "(", postfix = ")") { "${it[1]}, ${it[0]}" }

fun feast(beast: String, dish: String): Boolean = beast.take(1) == dish.take(1) && beast.takeLast(1) == dish.takeLast(1)

//Input:  {"I", "like", "big", "butts", "and", "I", "cannot", "lie!"}
//Output: {"!", "eilt", "onn", "acIdn", "ast", "t", "ubgibe", "kilI"}

fun reverse(a: List<String>): List<String> {
    var reversedString = a.joinToString("").reversed()
    val listResult = mutableListOf<String>()

    for (word in a) {
        val len = word.length
        val splitString = reversedString.take(len)
        listResult.add(splitString)
        reversedString = reversedString.drop(len)
    }
    return listResult
}
fun main() {
    val list = listOf("I", "like", "big", "butts", "and", "I", "cannot", "lie!")
    println(reverse(list))

    println("Hello".slice(0..1))


    /* print(meeting("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn"))
     return
     val friends1 = arrayOf("A1", "A2", "A3", "A4", "A5")
     val fTowns1 = arrayOf(arrayOf("A1", "X1"), arrayOf("A2", "X2"), arrayOf("A3", "X3"), arrayOf("A4", "X4"))
     val distTable1: MutableMap<String, Double> = HashMap()
     distTable1["X1"] = 100.0
     distTable1["X2"] = 200.0
     distTable1["X3"] = 250.0
     distTable1["X4"] = 300.0
     println(Tour.tour(friends1, fTowns1, distTable1))*/
}

object Tour {
    fun tour2(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {
        val ftwnsMap = ftwns.associate { Pair(it.first(), it.last()) }
        val distance = arrFriends.associateWith { s: String -> ftwnsMap[s] }
            .filter { it.value != null }
            .map { h[it.value] }

        val sum = distance.windowed(2) { list -> sqrt(list.last()!!.pow(2) - list.first()!!.pow(2)) }
            .sumOf { it }

        return (sum + distance.first()!! + distance.last()!!).toInt()
    }


    fun tour(arrFriends: Array<String>, ftwns: Array<Array<String>>, h: Map<String, Double>): Int {
        val towns = ftwns.associate { it.first() to it.last() }
        val distanceToFriends = arrFriends.mapNotNull { towns[it] }
            .mapNotNull { h[it] }.also { println(it) }
        val sum = distanceToFriends.windowed(2)
            .map { sqrt(it.last()!!.pow(2) - it.first()!!.pow(2)) }
            .sumOf { it }
        return (sum + distanceToFriends.first() + distanceToFriends.last()).toInt()
    }
}

