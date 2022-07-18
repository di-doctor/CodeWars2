fun main() {
    val strarr = arrayOf("tree", "foling", "trashy", "blue", "abcdef", "uvwxyz")
    val k = 2
    println(longestConsec2(strarr, k))
    println(longestConsec(strarr, k))
    println(longestConsec3(strarr, k))

    val listTestString = listOf<String>("one","two", "three")
    listTestString.slice(1..2).also { println(it) }

}


fun longestConsec(arr: Array<String>, k: Int): String {
    return if (k !in 1..arr.size) ""
    else {
        val resultList = mutableListOf<String>()
        for (index in 0..arr.size - k) {
            var string = ""
            for (i in index until index + k)
                string += arr[i]
            resultList.add(string)
        }
        //println(resultList)

        return resultList.maxByOrNull { it.length }!!
    }
}

fun longestConsec2(arr: Array<String>, k: Int): String {
    return if (k !in 0..arr.size) ""
    else {
        arr.toList()
            //.also { println(it) }
            .windowed(k)
            //.also { println(it) }
            .map { it.joinToString("") }
            // .also { println(it) }
            .maxByOrNull { it.length } ?: ""
    }
}

fun longestConsec3(strarr: Array<String>, k: Int) = (0..strarr.size - k)
    .also { println(it) }
    .map {
        strarr.slice(it until it + k).joinToString("")
    }
    .also { println(it) }
    .maxByOrNull { it.length }
    .orEmpty()