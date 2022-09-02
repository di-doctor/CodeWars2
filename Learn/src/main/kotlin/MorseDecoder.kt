import java.util.*

//Kotlin: MorseCode[".--"] ?: "" or MorseCode.getOrDefault(".--", "")
fun main() {
    val testList = listOf("mother","father","123").joinToString("").also { println(it) }


    println(decodeMorse(".... . -.--   .--- ..- -.. ."))
    decodeMorse2(".... . -.--   .--- ..- -.. .").also { println(it) }
    decodeMorse3(".... . -.--   .--- ..- -.. .").also { println(it) }
    decodeMorse4(".... . -.--   .--- ..- -.. .").also { println(it) }
}

fun decodeMorse(code: String): String {
    val arr = arrayOf(" ")
   return code.trim().split("   ")
        .joinToString(" ") {decodeWord(it)}
}
fun decodeWord(str:String): String{
   return str.split(" ")
        .joinToString("") { convertMorseToChar(it).toString().uppercase(Locale.getDefault()) }
}

fun decodeMorse2(code: String): String {
    return code.split(" ")
        .also { println(it) }
        .map { x -> convertMorseToChar(x)?.uppercaseChar() ?: " " }
        .joinToString("")
        .replace("  "," ")
        .trim()
}

fun decodeMorse3(code: String): String {
    return  code
        .split("   ")
        .joinToString(" ") {word->
            word.split(" ")
                .joinToString("") {char-> convertMorseToChar(char).toString().uppercase(Locale.getDefault()) }
        }
}
fun decodeMorse4(code: String):String{
    return code.split(" ")
        .joinToString("") { convertMorseToChar(it)?.toString()?.uppercase()?: " "}
        .replace(oldValue = "  ", newValue = " ")
}


fun convertMorseToChar(c: String) = when (c) {
    ".-" -> 'a'
    "-..." -> 'b'
    "-.-." -> 'c'
    "-.." -> 'd'
    "." -> 'e'
    "..-." -> 'f'
    "--." -> 'g'
    "...." -> 'h'
    ".." -> 'i'
    ".---" -> 'j'
    "-.-" -> 'k'
    ".-.." -> 'l'
    "--" -> 'm'
    "-." -> 'n'
    "---" -> 'o'
    ".--." -> 'p'
    "--.-" -> 'q'
    ".-." -> 'r'
    "..." -> 's'
    "-" -> 't'
    "..-" -> 'u'
    "...-" -> 'v'
    ".--" -> 'w'
    "-..-" -> 'x'
    "-.--" -> 'y'
    "--.." -> 'z'
    ".----" -> '1'
    "..---" -> '2'
    "...--" -> '3'
    "....-" -> '4'
    "....." -> '5'
    "-...." -> '6'
    "--..." -> '7'
    "---.." -> '8'
    "----." -> '9'
    "-----" -> '0'
    else -> null
}



