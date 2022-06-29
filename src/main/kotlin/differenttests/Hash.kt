package differenttests

fun main() {
    val playerOne = Player("El", "cool")
    val playerTwo = Player("El", "cool")
    println(playerOne == playerTwo)
    println(playerOne === playerTwo)
    println(playerOne.hashCode())
    println(playerTwo.hashCode())

    var str = "Ky"
    println(str.hashCode())
    str += "str"
    println(str.hashCode())

    println(Admin("Eldar") == Admin("Eldar"))
    val set = hashSetOf<Admin>()
    set.add(Admin("Eldar"))
    set.add(Admin("Eldar"))
    for (i in set) {
        println(i.toString())
    }
}

data class Player(val name: String, val status: String)

open class Admin(name: String) {
    private val _name = name

    override fun toString(): String {
        return "Hello, i'm admin $_name"
    }
}

class SubAdmin(name: String) : Admin(name) {
    private val _name = name
}