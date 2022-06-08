package differenttests

//var не может быть т. к. мы не можем менять значения при ковариантности
class Container<out T>(val data : T)

fun main() {
    val container: Container<Int> = Container(25)
    val container2: Container<Number> = container
}