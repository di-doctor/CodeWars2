import kotlin.random.Random

fun main() {

//   // println(encryptThis("A wise old owl lived in an oak")) //65 119esi 111dl 111lw 108dvei 105n 97n 111ka"
    val userFlow = listOf("Tom", "Bob", "Kate", "Sam", "Alice")
    println(encryptThis2("hello world")) // "104olle 119drlo"

   /* repeat(Random.nextInt(5, 10)) {
        val randomName = Random.nextInt(0, 101)
        println(randomName)
    }*/

}

fun encryptThis(text: String): String {
    val list = text.split(" ")
    val listresult = mutableListOf<String>()

    for (word in list) {
        val strResult = StringBuilder()
        if (word.length == 1) {
            strResult.append(word.first().code)

        } else if (word.length == 2) {
            strResult.append(word.first().code)
            strResult.append(word[1])

        } else {
            strResult.append(word.first().code)
            strResult.append(word.last())
            for (i in 2 until word.length - 1) {
                strResult.append(word[i])
            }
            strResult.append(word[1])
        }
        listresult.add(strResult.toString())
    }
    return listresult.joinToString(" ")

}

fun encryptThis2(text: String): String {
    return  text.split(" ")
        .map { it.first().code.toString() + it.takeLast(1) + it.drop(2).dropLast(1)+ it.take(2).drop(1)  }
        .joinToString (" ")
}

