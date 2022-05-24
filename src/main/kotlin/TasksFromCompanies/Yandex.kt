package TasksFromCompanies

class Yandex {

}

fun main() {
    /*
    var num = readLine()
    var first = num?.substring(0..2)?.toInt() ?: 0
    var firstDel = first
    var second = num?.substring(3..5)?.toInt() ?: 0
    var secondDel = second
    var firstSum = 0
    var secondSum = 0
    while (firstDel > 0 ){
        firstSum += firstDel%10
        firstDel /= 10
        secondSum += secondDel%10
        secondDel /= 10
    }
    while (true){
        if (firstSum == secondSum){
            break
        }else{
            second++
            secondDel = second
            secondSum = 0
            while (secondDel > 0 ){
                secondSum += secondDel%10
                secondDel /= 10
            }
        }
    }
    val zeros = if (second < 10) "00"
                else if (second < 100) "0"
                else ""
    println(first.toString() + zeros + second.toString())
    /*
    val arr = Array(6) { 0 }
    var i = 5
    while (num > 0){
        arr[i] = num % 10
        num /= 10
        i--
    }
    val raz = arr[0] + arr[1] + arr[2] - arr[3] - arr[4] - arr[5]

    println(arr.toList().toString())

     */

     */

    /*
    val start = readLine()?.split(":")
    val end = readLine()?.split(":")
    val poas = readLine()
    val answer = arrayOf<String>("","")
    if (end!![1].toInt() - start!![1].toInt() > 0){
        answer[1] = (end!![1].toInt() - start!![1].toInt()).toString()
        answer[0] = (end!![0].toInt() - start!![0 - poas!!.toInt()].toInt()).toString()
    }else{
        answer[1] = (60 - start!![1].toInt() + end!![1].toInt()).toString()
        answer[0] = (end!![0].toInt() - start!![0].toInt() - 1 - poas!!.toInt()).toString()
    }
    val zeros = if (answer[1].toInt() < 10) "0"
                else ""
    println("${answer[0]}:$zeros${answer[1]}")

     */
    var first = readLine()?.toInt() ?: 0
    var second = readLine()?.toInt() ?: 0
    println(first+second)
    val z = arrayOf(1,2)
    val k = arrayOf(3,4)
    println((z+k).toList().toString())
    var a = readLine()?.toInt() ?: 0
    var b = readLine()?.toInt() ?: 0
    var n = readLine()?.toInt() ?: 0
    if (a < b) println("Yes")
    else println("No")


}