package differenttests

interface Base {
    fun print()
}

class BaseImpl(private val x: Int) : Base {
    override fun print() { print(x) }
}

open class Derived(b: Base) : Base by b

class SubDerived(b: Base) : Derived(b){
    override fun print() {
        print("hi")
    }
}

fun main() {
    val b = BaseImpl(10)
    val derived = Derived(b)
    val subDerived = SubDerived(derived)
    subDerived.print()
}