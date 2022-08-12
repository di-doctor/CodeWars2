fun main() {
    val a1 = arrayOf("live", "strong", "arp")
    val a2 = arrayOf("livelystrong", "alive", "harp", "sharp")
    println(inArray(a1, a2).joinToString())

}

fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
    val strResultSet = mutableSetOf<String>()
    for (strFromArr2 in array2)
        for (strFromArr1 in array1) {
            if (strFromArr2.contains(strFromArr1)) strResultSet.add(strFromArr1)
        }
    return strResultSet.sorted().toTypedArray()
}

fun inArray2(array1: Array<String>, array2: Array<String>): Array<String> {
    val strResultSet = mutableSetOf<String>()
    for (str1 in array1) {
        if (array2.any { it.contains(str1) }) strResultSet.add(str1)
    }
    return strResultSet.sorted().toTypedArray()
}

fun inArray3(array1: Array<String>, array2: Array<String>): Array<String> {
    val strResultSet = mutableSetOf<String>()
    array1.forEach { str1 -> if (array2.any { it.contains(str1) }) strResultSet.add(str1) }
    return strResultSet
        .distinct()
        .sorted()
        .toTypedArray()
}


fun inArray4(array1: Array<String>, array2: Array<String>): Array<String> {
    return array1.toSet()
        .filter { str1 -> array2.any { it.contains(str1) } }
        .sorted()
        .toTypedArray()
}

fun inArray5(array1: Array<String>, array2: Array<String>): Array<String> {
    val strResultSet = mutableSetOf<String>()
    array1.forEach { str1 ->
        array2.forEach {
            if (it.contains(str1)) strResultSet.add(str1)
        }
    }
    return strResultSet
        .distinct()
        .sorted()
        .toTypedArray()

}

