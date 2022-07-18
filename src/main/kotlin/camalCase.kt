fun main() {
    val listInt = listOf<Int>(1,2,3)
    listInt.fold(0){sum,item->sum+item+1}.also { println(it) }

    "home_car_tree".split(Regex("_|-"))
        .reduce{ fullString, word -> fullString + word.capitalize() }
        .also { println(it) }

    val str1 = "the-stealth-warrior"
    val str2 = "The_Stealth_Warrior"
    val list = listOf<String>("home","Car","tree").also { println(it) }
        .drop(1).also { println(it) }
        .joinToString(" ") { it }
        .also { println(it) }

    toCamelCase(str1).also { println(it) }
    toCamelCase(str2).also { println(it) }
    println()
    toCamelCase2(str1).also { println(it) }
    toCamelCase2(str2).also { println(it) }
}

fun toCamelCase(str: String): String {
    val strResult = StringBuilder()
    val list = str.split("""[-_]""".toRegex())
    strResult.append(list.first())
    for (index in 1 until list.size) {
        strResult.append(list[index].capitalize())
    }
    return strResult.toString()
}

fun toCamelCase2(str: String): String {
    return str.split(Regex("""[-_]"""))
        .mapIndexed { index, item -> if (index == 0) item else item.capitalize() }
        .joinToString("")

}

//"the-stealth-warrior" gets converted to "theStealthWarrior"
//"The_Stealth_Warrior" gets converted to "TheStealthWarrior"