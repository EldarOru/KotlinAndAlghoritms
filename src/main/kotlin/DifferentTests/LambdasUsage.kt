package DifferentTests

interface ClickListener{
    fun onClick()
}

class LambdasUsage {
    fun setOnClickListener(l: ClickListener){

    }

    fun checkLambda2(tr: (Int) -> Unit){

    }
    companion object{
        val lambda: (Int, Int) -> Int = {v, l ->
            if(v > l) v+l
        else v}
        fun checkLambda(s: Int, lambda: (Int, Int) -> Int){
            println("$s + ${lambda(s,s+2)}")
        }

    }
}

fun main() {
    val arr = Array(5) { it }
    val lambdasUsage = LambdasUsage()
    lambdasUsage.checkLambda2 { println(it) }
    val aa = {i: Int -> println(i)}
    aa(5)
    LambdasUsage.lambda(3, 2)
    var f = 12
    f = f add 2
    println(f)
    f += 2

    LambdasUsage.checkLambda(5) { v, l -> v + l }
    LambdasUsage.checkLambda(5, LambdasUsage.lambda)

    val lam: (Int, Int) -> (Unit) = {a:Int, b:Int -> println("hi $a and $b")}
    /*
    val arr = readLine()!!.split(" ").map { it.toInt() }
    val hm = hashMapOf<Int, Int>()
    for (i in arr[0]..arr[1]){
        var count = 0
        for (j in 1..i){
            if (i % j == 0){
                count++
            }
        }
        hm[i] = count }
    println(hm.toList().sortedBy { (key, value) -> value }.toMap())
     */

}

infix fun Int.add(k: Int): Int{
    return this + k
}