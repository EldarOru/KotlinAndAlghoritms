package differenttests

interface Soup {
    fun eat()
}

class MisoSoup: Soup {
    override fun eat() {
        println("I'm miso soup")
    }
}

class Borsh: Soup {
    override fun eat() {
        println ("I'm borsh")
    }
}

class Factory {
    fun getSoup(soupTypes: SoupTypes): Soup {
        return when(soupTypes) {
            SoupTypes.BORSH -> Borsh()
            SoupTypes.MISO_SOUP -> MisoSoup()
            else -> throw Exception()
        }
    }
}

enum class SoupTypes{
    BORSH,
    MISO_SOUP
}