fun main() {
    println(solution(10)) //23
    println(solution(20)) //78
    println(solution(200)) //9168

    val set1 = setOf<Int>(3,5,8,10)
    val set2 = setOf<Int>(3,5,2,12)
    println(set1.union(set2))
    println(set1.intersect(set2))
    println(set1.subtract(set2))
    set1.union(set2).subtract(set1.intersect(set2)).also { println(it) }
}

fun solution(number: Int): Int {
    if (number < 0) return 0
    return (0 until number).filter { num -> num % 3 == 0 || num % 5 == 0 }.sum()
}