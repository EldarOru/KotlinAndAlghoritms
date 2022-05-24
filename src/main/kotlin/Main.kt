import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.*
import kotlin.random.Random

fun main() {
    val str = readLine()?.split(" ") ?: arrayListOf("0", "0")
    val a = str[0].toInt()
    val b = str[1].toInt()
    println(a+b)
    println(intArrayOf(1, 3, 7, 2, 3, 4, 2, 8).selectionSort().toList())

    println(intArrayOf(1, 3, 7, 2, 3, 4, 2, 8).bubbleSort().toList())

    println(factorial(5))

    println(generate(5))

    val arrayList = arrayListOf<Int>()
    arrayList.add(0)

    //newArrayList и arrayList ссыляются на один объект и при изменении обе ссылки будут знать об этом
    val newArrayList = arrayList
    arrayList.add(1)
    arrayList += 5
    println("ATTENTION")
    println(arrayList)
    println(newArrayList)
    val newArr = arrayList.clone()
    println(newArr === arrayList)
    println(newArr == arrayList)
    println("${newArrayList.hashCode()}  ${arrayList.hashCode()}  ${newArr.hashCode()}")

    var cinema = arrayOf(1, 2)
    var newCinema = cinema
    //копирует существующий массив, добавляет больший размер и делает 1
    cinema += 1
    //cinema и newCinema не будут одинаковыми т.к cinema += 1 пересоздает объект -> cinema и newCinema не ссыляются на один объект
    println(cinema.toList().toString())
    println(newCinema.toList().toString())

    var list = listOf(1, 2, 3)
    println("List is ${list.javaClass.name.toString()}")
    list  += 5


    val array = arrayOfNulls<String>(5)
    //Сохраняет очередность добавления
    val lOne = hashSetOf<Int>()
    val l = linkedSetOf<Int>()
    l.add(5)
    l.add(1)
    l.add(2)
    println(l.toList().toString())

    val h = hashSetOf<Int>()
    h.add(5)
    h.add(1)
    h.add(2)
    println(h.toList().toString())
    println(h.javaClass.name.toString())

    val t = setOf(9, 2, 3, 4)
    println(t.javaClass.name.toString())
    var mapOne = hashMapOf<String,String>()
    mapOne["Str"] = "str"
    println(mapOne)
    var mapTwo = linkedMapOf(2 to "STR")

    var map = mapOf<Int, String>()
    map += 5 to "Kek"
    println(map)
    println(map.javaClass.name.toString())

    /*
    val arr = List(50){ Random.nextInt(-100,100)}
    println(arr)
    staircase(6)
    println(timeInWords(1, 1))
    println(birthdayCakeCandles(arrayOf(3,2,1,3)))
    println(getMinimumCost(2, arrayOf(2,5,6)))
    println(gradingStudents(arrayOf(73,67,38,33)).toList())
    encryption("iffactsdontfittotheorychangethefacts")
    encryption("feedthedog")
     */
    val v = "kek"
    v.forEach {  }
    v.forEachIndexed { index, c ->  }
    val z = arrayOf(1,2)
    val k = arrayOf(3,4)
    print(z+k)
    println(::staircase.invoke(5))
}

fun staircase(n: Int) {
    for (i in 1..n){
        println(" ".repeat(n-i) + "#".repeat(i))
    }

}


fun encryption(s: String): String {
    val stringLength = s.length
    println(sqrt(stringLength.toDouble()))
    val rows = Math.floor(sqrt(stringLength.toDouble())).toInt()

    val columns = if (rows * rows == stringLength) { rows}
    else rows + 1

    val arr = arrayListOf<ArrayList<String>>()
    var const = 0
    if (rows * columns > stringLength){
        for (j in 0..rows) {
            val array = arrayListOf<String>()
            for (i in 0 until columns) {
                if (i + const > stringLength - 1) break
                array.add(s[i + const].toString() ?: "")
            }
            if (array.isEmpty()){

            }else arr.add(array)
            const += columns
        }
    }else{
        for (j in 0..rows+1) {
            val array = arrayListOf<String>()
            for (i in 0 until columns) {
                if (i + const > stringLength - 1) break
                array.add(s[i + const].toString() ?: "")
            }
            if (array.isEmpty()){

            }else arr.add(array)
            const += columns
        }
    }

    if (arr[arr.size - 1].size < columns){
        for (i in 0..columns - arr[arr.size - 1].size){
            arr[arr.size - 1].add("")
        }
    }
    var returnString = ""
    var k = 0
    while (k < columns){
        for (v in 0 until arr.size){
            if (arr[v][k] == ""){

            }else returnString += arr[v][k]
        }
        returnString += " "
        k++

    }
    println(arr.toList())
    println(returnString)
    return returnString


}

fun timeInWords(h: Int, m: Int): String {
    val numMap = hashMapOf(
        0 to "",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "thirty"
    )
    val partMap = hashMapOf<Int, String>(
        15 to "quarter past",
        30 to "half past",
        45 to "quarter to"
    )

    if (partMap.keys.contains(m) && m == 45) return "${partMap[m]} ${numMap[h + 1]}"
    if (partMap.keys.contains(m)) return "${partMap[m]} ${numMap[h]}"
    if ( m == 0) return "${numMap[h]} o' clock"
    var minNum = ""
    minNum = if (m > 30){
        if (60 - m >= 20){
            "${numMap[60-m - ((60 - m) % 10)]} ${numMap[(60 - m) % 10]}"
        }else "${numMap[60 - m]}"
    }else{
        if (m >= 20){
            "${numMap[m - m % 10]} ${numMap[m % 10]}"
        }else "${numMap[m]}"
    }

    var hourNum = ""
    hourNum = if (m > 30) numMap[h + 1] ?: "0"
    else numMap[h] ?: "0"

    return if (m > 30){
        when (60 - m){
            1 -> "$minNum minute to $hourNum"
            else -> "$minNum minutes to $hourNum"
        }}
    else{
        when(m){
            1 -> "$minNum minute past $hourNum"
            else -> "$minNum minutes past $hourNum"
        }}
}

fun miniMaxSum(arr: Array<Int>): Unit {
    val newArr = arr.sortedArray()
    println(newArr.toList().toString())
    var answer = ""
    var num = 0L
    for (i in newArr.size - 2 downTo 0){
        num += newArr[i]
    }
    answer += num
    num = 0L
    for (i in 1 until newArr.size){
        num += newArr[i]
    }
    answer += " $num"
    println(answer)
}


fun plusMinus(arr: Array<Int>): Unit {
    var positive = 0
    var negative = 0
    var zeros = 0
    for (i in arr){
        if (i > 0) positive++
        else if (i < 0) negative++
        else zeros ++
    }
    println(positive.toDouble()/arr.size.toDouble())
    println(negative/arr.size)
    println(zeros/arr.size)
}

//сделать
fun matrixMultiplication(){

}

fun getMinimumCost(k: Int, c: Array<Int>): Int {
    val arr = Array(k){0}
    println(arr.toList())
    val flowersArr = c.sortedArray()
    var flowersCount = c.size - 1
    var sum = 0

    while (flowersCount > -1){
        for (j in arr.indices){
            println("sum = $sum  arr = ${arr[j]} flower = ${flowersArr[flowersCount]}")
            sum += (arr[j] + 1) * flowersArr[flowersCount]
            arr[j] ++
            flowersCount --
            if (flowersCount == -1) break
        }
    }
    return sum
}

fun gradingStudents(grades: Array<Int>): Array<Int> {
    val result = Array(grades.size){0}
    for (i in grades.indices){
        if(grades[i] < 38) {result[i] = grades[i]}
        else{
            if ((grades[i] + 2) % 5 == 0 || (grades[i] + 1) % 5 == 0){
                result[i] = grades[i] + (5 - grades[i] % 5)
            }else result[i] = grades[i]
        }
    }
    return result
}
fun birthdayCakeCandles(candles: Array<Int>): Int {
    if (candles.size == 1) return candles[0]
    val sortArray = candles.sortedArray().reversedArray()
    var count = 0
    for (i in sortArray.indices){
        if (sortArray[0] == sortArray[i]){
            count++
        }else break
    }
    return count
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

fun IntArray.swap(a: Int,b: Int){
    val change = this[a]
    this[a] = this[b]
    this[b] = change
}

fun IntArray.selectionSort(): IntArray{
    val beginTime = System.nanoTime()
    for (i in this.indices){
        var min = i
        for (j in i+1 until this.size){
            if (this[j] < this[min]){
                min = j
            }
        }
        this.swap(i,min)
    }
    println(System.nanoTime() - beginTime)
    return this
}

fun factorial(n: Int): Double = if (n < 2) 1.0 else n * factorial(n - 1)

fun generate(numRows: Int): List<List<Int>>{
    val returnList = arrayListOf<ArrayList<Int>>()
    if (numRows == 0) return returnList
    returnList.add(arrayListOf())
    returnList[0].add(1)
    if (numRows == 1) return returnList
    returnList.add(arrayListOf())
    returnList[1].add(1)
    returnList[1].add(1)
    if (numRows == 2) return returnList

    for (i in 2 until numRows){
        returnList.add(arrayListOf())
        returnList[i].add(1)
        for (j in 1 until i){
            returnList[i].add(returnList[i-1][j-1] + returnList[i-1][j])
        }
        returnList[i].add(1)
    }

    return returnList
}

