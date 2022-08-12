fun main() {
  val b = B()
    b.yell()
    b.up()
    b.runOf()

}

class B : Test() {
   fun mod(){}

     public override fun runOf() {
        println("FromB runOf")
    }
}

open class Test {
    fun yell() {
        println("From Yell")
    }

    protected open fun runOf() {
        println("From Run")
    }
}



fun Test.up() {
    yell()

}