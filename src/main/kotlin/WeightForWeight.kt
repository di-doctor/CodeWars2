fun <T> copyThanGreater(list: List<T>, thereHold: T): List<String>
        where   T : Comparable<T> {
    return list.filter { it > thereHold }.map { it.toString() }
}

data class User(val name: String, val id: Int): Comparable<User>{
    override fun compareTo(other: User): Int {
        return  this.id-other.id
    }

}

fun main() {
    val listUser = listOf<User>(User("Dima",30),User("Kolya",25),User("Tanya", 23),User(name = "Petya",52))
    val list = listOf(1, 2, 3, 4, 6, 8)
    val list2 = listOf("e", "d", "s", "m", "a")


    copyThanGreater(listUser,User("", 24)).also { println(it) }

    val str = "56 65 74 100 99 68 86 180 90".also { println(it) }
    println(orderWeight(str))
    println(orderWeight2(str))

    Integer.valueOf("12").also { println(it) }
    Integer.parseInt("56").also { println(it) }


}

fun orderWeight(string: String): String {
    if (string.isEmpty()) return ""
    val resultList: MutableList<String> = mutableListOf()
    val map = string.split(" ").groupBy { item ->
        item.chunked(1)
            .sumOf { it.toInt() }
    }.toSortedMap()

    for (entry in map) {
        entry.value.sorted().also { resultList.addAll(it) }
    }

    return resultList.joinToString(" ")
}


fun orderWeight2(string: String): String {
    return string.split(" ")
        .sorted()
        .sortedWith(compareBy { str -> str.chunked(1).sumOf { char -> char.toInt() } })
        .joinToString(" ")
}