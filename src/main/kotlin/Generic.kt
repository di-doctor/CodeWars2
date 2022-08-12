import kotlin.math.ceil

//assertEquals("docdmkco", moveTen("testcase"))
//assertEquals("mynogkbc", moveTen("codewars"))

fun main() {

    println(moveTen2("testcase"))
    println(moveTen3("codewars"))
    println(('a'+1))


}

fun past(h: Int, m: Int, s: Int): Int = (h * 3600 + m * 60 + s) * 1000

val numbers = arrayOf<String>(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen",
    "twenty"
)

fun wallpaper(l: Double, w: Double, h: Double): String {
    if (l * w * h == 0.0) return "zero"
    val square: Double = (l + w) * 2 * h * 1.15
    return numbers[ceil(square / (10 * 0.52)).toInt()]

}

fun moveTen(s: String): String {
    val result = StringBuilder()
    for (char in s) {
        result.append(char.forfardChar())
    }
    return result.toString()
}

fun moveTen2(s: String): String {
    return s.map(Char::forfardChar).joinToString("")
}

fun moveTen3(s: String): String {
    return s.map { if (it.code + 10 > 122) it - 16 else it.code + 10 }.joinToString("")
}


fun Char.forfardChar(): Char {
    val codeZ = 'z'.code
    val codeA = 'a'.code
    val resultCharCode = code + 10
    if (resultCharCode > codeZ) {
        return (resultCharCode - codeZ + codeA - 1).toChar()
    }
    return resultCharCode.toChar()
}