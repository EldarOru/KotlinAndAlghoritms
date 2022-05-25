package solveproblems

fun IntArray.swap(a: Int,b: Int){
    this[a] = this[a] xor this[b] // a = (a ^ b), b = b
    this[b] = this[b] xor this[a] // a = (a ^ b), b = (a ^ b ^ b) = a
    this[a] = this[a] xor this[b] // a = (a ^ b ^ a) = b, b = a
}

fun IntArray.bubbleSort(): IntArray {
    var sorted = false
    while (!sorted) {
        sorted = true
        for (i in 1 until this.size) {
            val previous = this[i - 1]
            val current = this[i]
            if (previous > current) {
                this.swap(i - 1, i)
                sorted = false
            }
        }
    }
    return this
}

fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (i in nums) {
        result = result xor i
    }
    return result
}


fun main(){
    val n = try {
        readLine()?.toInt() ?: 0
    }catch (io: Exception){
        0
    }
    val arrList = ArrayList<Int>()
    for (i in 1..n){
        arrList.add(readLine()?.toInt() ?: 0)
    }

    println(arrList.toIntArray().bubbleSort().toList().toString())
    println(singleNumber(arrList.toIntArray()))
    println(5 xor 3)
}