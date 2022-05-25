package differenttests

data class Test(var str: String) {
}

fun main() {
    val arr = arrayListOf<Test>()
    arr.add(Test("Zero"))
    arr.add(Test("One"))
    arr.add(0, Test("Two"))
    val test = arr[2]
    arr.removeAt(2)
    arr.remove(Test("Zero"))

    arr.add(Test("kek"))
    val test1 = arr[1]
    test1.str = "lol"

    arr.forEach { println(it.str) }

    val n1 = "hi"
    val n2 = "hi"
    println(n1 == n2)

    val a = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8)
    check(a)
    println(a.toString())

}

fun check(array: ArrayList<Int>){
    array[2] = array[1]
    //array = arrayListOf()
}