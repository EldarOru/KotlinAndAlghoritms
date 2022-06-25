package differenttests

import kotlin.math.max


fun main() {
    val count = readLine()!!.toInt()
    val str = readLine()!!.toString()
    val time = readLine()!!.trim().split("\\s+".toRegex()).map (String::toInt)

    val hm = hashMapOf<Char, Int>()
    var currentTime = 0
    for (i in str.indices) {
        hm[str[i]] = hm.getOrDefault(str[i], 0) + time[i] - currentTime
        currentTime = time[i]
    }

    var maxValue = 0
    var endChar = 'a'
    for(i in hm) {
        println("${i.key} -- ${i.value}")
        if (i.value >= maxValue) {
            endChar = i.key
            maxValue = i.value
        }
    }

    val maxEntry = hm.maxWithOrNull { x, y ->
        x.value.compareTo(y.value) }
    println(maxEntry)

    println(endChar)
}