package Test

abstract class Animal(age: Int, name: String) {
    abstract val const: String
    abstract fun eat()
    open fun roar(){
        println("ryaa")
    }
}

open class Tiger(age: Int, name: String): Animal(age, name){
    override val const: String
        get() = "Hi"
    val _age = age
    override fun eat() {
        _age
        TODO("Not yet implemented")
    }

    override fun roar() {
        println("not ryya")
    }

    fun sleep(){

    }

    override fun equals(other: Any?): Boolean {
        if (other is TestTiger){
            return this._age == other._age
        }
        return false
    }
}

class TestTiger constructor(age: Int, name: String): Tiger(age, name){
    override fun eat() {
        super.eat()
    }

    constructor(age: Int, name: String, sex: String) : this(age, name){
        println("second constructor is here")
    }

    init {
        println("init is here!")
    }
}

fun main() {
    val t = TestTiger(5, "test", "male")
    val t1 = TestTiger(5, "test", "male")
    t.roar()
    t.const
    println(t==t1)
    val hashMap = hashMapOf<TestTiger, String>()
    hashMap[t] = "TigerOne"
    hashMap[t1] = "TigerTwo"
    println(hashMap.toList().toString())
}