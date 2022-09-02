package MK

import kotlin.random.Random

fun foo(param: Int, execute: (x: Int) -> Int): Int {

    return execute(param)
}


fun Int.cub(): Int {
    return this * this * this
}


fun main() {
    val l = { x: Int -> x * 2 }
    foo(5) { x -> x * 5 }.also { println(it) }

    foo(3, Int::cub).also { println(it) }
    val value = 10




}

/*1      => null
25     => null
36     => 36
1244   => 12
952406 => 9*/

fun findShort(s: String): Int {
    return s.split(" ")

        .minByOrNull { it.length }?.toInt() ?: 0
}

fun prevMultOfThree(n: Int): Int? {
    var result = n
    while (result != 0) {
        if (result % 3 == 0) return result
        else {
            result /= 10
        }
    }
    return null
}