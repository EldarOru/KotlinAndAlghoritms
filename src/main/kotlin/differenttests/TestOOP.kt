import java.util.*

open class ClassA(val num: Int, str: String): TestInterface {
    val kek = str

    override fun printCheck() {
        println(kek)
    }

    open fun giveInfo(){
        println(num)
    }

    fun checkMethod() {}
}


class ClassB(num: Int, info: String, str: String, lambda: (Int) -> Unit): ClassA(num, str){
    private val _info = info
    override fun giveInfo() {
        println("$num $_info")
    }


    fun myMethod(){
        println("Ku")
        checkMethod()
    }
}


interface TestInterface{
    fun printCheck()
    fun or(str: String){
        println(str)
    }
}

data class T(val number: Int = 5){
    fun kek(){

    }
}

//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------

class V: Lolik(){
    override fun or() {
        super.k()
    }



}


class B() : Kokik{
    override val h: Int
        get() = super.h

    override fun ory() {
        TODO("Not yet implemented")
    }

    override fun oro() {
        TODO("Not yet implemented")
    }


}

/*
Интерфейсы в Kotlin могут содержать объявления абстрактных методов, а также методы с реализацией.
Главное отличие интерфейсов от абстрактных классов заключается в невозможности хранения переменных экземпляров.
Они могут иметь свойства, но те должны быть либо абстрактными, либо предоставлять реализацию методов доступа.
 */

abstract class Lolik{
    private val h = 5
    abstract fun or()
    open fun ori(){

    }
    fun k(){

    }
    //fun k() error
}

interface Kokik{
    val h: Int
    get() = 5

    //val h = 5 error
    abstract fun ory()

    fun oro()

    fun checkMethod(){

    }
}

//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------

class EqualObject(private val str: String, val int: Int){
    override fun equals(other: Any?): Boolean {
        return if (other is EqualObject){
            str == other.str && int == other.int
        } else false
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
fun main() {
    val classB: ClassA = ClassB(6, "kek", ""){
        if (it > 0){
            println("yes")
        }else println("no")
    }

    classB.checkMethod()
    classB.giveInfo()
    //classB.myMethod() doesn't work
    val moreClassB = ClassB(6, "kek", ""){
        if (it > 0){
            println("yes")
        }else println("no")
    }
    moreClassB.myMethod()
    moreClassB.checkMethod()
    moreClassB.giveInfo()

    val t1 = T(6)
    val t2 = T(6)
    println(t1 == t2)
    println(t1 === t2)
    println(t1.hashCode())
    println(t2.hashCode())

    val v1 = V()
    val v2 = V()
    println(v1 == v2)
    println(v1.hashCode())
    println(v2.hashCode())
    val myClass = object : Lolik(){
        override fun or() {
            TODO("Not yet implemented")
        }
    }
    mysteryFunction(3)

    val ob1 = EqualObject("el", 5)
    val ob2 = EqualObject("el", 5)
    println(ob1 == ob2)

    val z: M = Z()
    z.returnKek()

    ret(ClassB(5,"srt", "s") {})
}

fun check(n: Int){
    for (i in 1..n){
        println(i)
    }
}
fun mysteryFunction(n: Int): Int{
    var r = 0
    for (i in 1 until n){
        for (j in i+1..n){
            for (k in 1..j){
                r ++
            }
        }
    }
    return r
}
interface M{
    public fun returnKek(){
        println("EL")
    }
}

open class N(val data: Int = 5): M{
    open val k = 5
    override fun returnKek() {
        println("NO EL")
    }

    open fun rr(){

    }
}

class Z(): N(){
    override val k: Int
        get() = super.k
}

sealed class Resource<T> (val data: T? = null, val message: String? = null){
    class Success<T>(data: T?): Resource<T>(data)
}

fun ret(v: ClassA) = v