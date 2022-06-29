package differenttests

open class ClassA(val num: Int, str: String): TestInterface {
    val kek = str

    override fun printCheck() {
        println(kek)
    }

    open fun giveInfo(){
        println(num)
    }

    open fun checkMethod() {}

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}


class ClassB(num: Int, info: String, str: String, val lambda: (Int) -> Unit): ClassA(num, str){
    val _info = info
    override fun giveInfo() {
        println("$num $_info")
    }


    fun myMethod(){
        println("Ku")
        checkMethod()
        lambda(num)

    }

    override fun checkMethod() {
        super.checkMethod()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}


interface TestInterface{
    fun printCheck()
    fun or(str: String){
        println(str)
        return
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

class B() : Kokik {
    override val h: Int
        get() = super.h

    override fun ory() {
        TODO("Not yet implemented")
    }

    override fun oro() {
        TODO("Not yet implemented")
    }

    override fun checkMethod() {
        super.checkMethod()
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
class Person(var n: Int) {

}
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
    ob1.int
    println(ob1 == ob2)

    val z: M = Z()
    z.returnKek()

    ret(ClassB(5,"srt", "s") {})

    val p1 = Person(2)
    var arr = arrayOf(p1)
    var arr1 = arrayOf(p1)
    println(arr.contentEquals(arr1))
    p1.n = 5
    println(arr[0].n)

    val arra = arrayListOf<Person>(Person(5))
    val p = arra[0]
    p.n = 2
    println(arra[0].n)

    val ai: ClassA = ClassB(5, "fa", "d") {it -> print(it)}
    ai.giveInfo()

    val p2 = Person(100)
    changePerson(p2)
    println(p2.n)

    val range = 0..10 step 2
    println(range)
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

interface O {
    fun hello()
}
private interface M : O{
    val num: Int
        get() = 5

    public fun returnKek(){
        println("EL")
    }

    companion object{
        const val myNum = 5
    }
}

open class N(val data: Int = 5): M {
    open val k = 5
    override fun returnKek() {
        println("NO EL")
    }

    override fun hello() {
        TODO("Not yet implemented")
    }

    open fun rr(){

    }

    override val num: Int
        get() = 2
}

class Z constructor() : N(){
    override val k: Int
        get() = super.k
}

sealed class Resource<T> (val data: T? = null, val message: String? = null){
    class Success<T>(data: T?): Resource<T>(data)
}

fun ret(v: ClassA) = v

fun changePerson(p: Person) {
    p.n = 10
}