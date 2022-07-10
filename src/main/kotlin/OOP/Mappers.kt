package OOP

interface Person {

    fun <T> map(mapper: Mapper<T>): T

    class Base(private val id: Int, private val name: String, private val surName: String): Person {
        override fun <T> map(mapper: Mapper<T>) = mapper.map(id, name, surName)
    }

    interface Mapper<T> {
        fun map(id: Int, name: String, surName: String): T

        class CompareId(private val id: Int): Mapper<Boolean>{
            override fun map(id: Int, name: String, surName: String) = this.id == id
        }

        class Same(private val person: Person): Mapper<Boolean>{
            override fun map(id: Int, name: String, surName: String) = person.map(CompareId(id))
        }

        class SaveId(private val idContainer: Save<Int>): Mapper<Unit>{
            override fun map(id: Int, name: String, surName: String) {
                idContainer.save(id)
            }
        }

        class FullName: Mapper<String>{
            override fun map(id: Int, name: String, surName: String) = "$name $surName"
        }
    }
}

interface Save<T> {
    fun save(obj: T)
}

interface Read<T> {
    fun read(consumer: Consumer<T>)
}

interface Consumer<T> {
    fun use(obj: T)
}

class SavePersonId: Save<Int>, Read<Int> {
    private var id: Int = 0

    override fun save(obj: Int) {
        id = obj
    }

    override fun read(consumer: Consumer<Int>) {
        consumer.use(id)
    }
}

fun main() {
    val person = Person.Base(1, "El", "Oru")
    val personTwo = Person.Base(1, "Nick", "Fed")
    val result = person.map(Person.Mapper.Same(personTwo))
    println(result)

    val showId = object : Consumer<Int>{
        override fun use(obj: Int) {
            println(obj)
        }
    }

    val save = SavePersonId()
    person.map(Person.Mapper.SaveId(save))
    save.read(showId)

    val fullName = person.map(Person.Mapper.FullName())
    println(fullName)
}