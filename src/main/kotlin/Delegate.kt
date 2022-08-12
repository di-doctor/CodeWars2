import kotlin.properties.Delegates

interface Base {
    val message: String
    fun print()
}

class BaseImpl(private val x: Int) : Base {
    override val message: String = "BaseImpl: x = $x"
    override fun print() {
        println(message)

    }

}

class Derived(private val b : BaseImpl) : Base by b {
    // Это свойство недоступно из `b` реализации `print`
    override val message = "Message of Derived"

}
class Animal {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("${prop.name} --$old - $new")

    }
}


fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    derived.print()
    println(derived.message)
    val animal = Animal()
    animal.name = "Dog"
    animal.name = "Cat"
}