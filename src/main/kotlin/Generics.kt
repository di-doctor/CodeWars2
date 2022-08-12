fun main() {

}

interface Source<out T> {
    fun nextT(): T
}

class User2(val name: String, val id: Int) : Source<String> {
    override fun nextT(): String {
        TODO("Not yet implemented")
    }
}

fun demo(strs: Source<String>): Unit {
    val obj: Source<Any> = strs
    obj.nextT()
}