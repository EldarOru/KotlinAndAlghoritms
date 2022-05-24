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

}

data class Player(val name: String, val status: String)