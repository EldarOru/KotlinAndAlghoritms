package solveproblems

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs
import kotlin.math.min

fun main() {
    //println(firstPalindrome(arrayOf("abc","car","ada")))
    //println(sumOfUnique(intArrayOf(1,2,3,2)))
    //println(isHappy(19))
    //println(canBeTypedWords("leet code", "lt"))
    //println(minCostToMoveChips(intArrayOf(1,1,1,3,3)))
    //println(subtractProductAndSum(234))
    //println(luckyNumbers(arrayOf(intArrayOf(1,10,4,2), intArrayOf(9,3,8,7), intArrayOf(15,16,17,12))))
    //println(kidsWithCandies(intArrayOf(1,2,3),5))
    //println(restoreString("codeleet", intArrayOf(4,5,6,7,0,2,1,3)))
    //println(shuffle(intArrayOf(2,5,1,3,4,7),3).toList())
    //val data = "мама мыла раму"
    //val arrData = data.toList()
    //println(solveproblems.reverse(arrData).toString())
    println(findComplement(5))
}

fun firstPalindrome(words: Array<String>): String {
    for (i in words){
        var str = ""
        i.reversed()
        for (j in i.length - 1 downTo 0){
            str += i[j].toString()
        }
        if (i == str) return str
    }
    return ""
}

fun sumOfUnique(nums: IntArray): Int {
    var returnSum = 0
    val s = hashMapOf<Int, Int>()
    for (i in nums){
        if (s.containsKey(i)){
            s[i] = s[i]!!.plus(1)
        }else{
            s[i] = 1
        }
    }
    println(s)
    for (i in s){
        if (i.value == 1){
            returnSum += i.key
        }
    }
    return returnSum
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var max = 0
    for (i in grid.indices){
        for (j in grid[i].indices){
            if(grid[i][j] == 1){
                max = Math.max(max, checkIsland(grid, i, j))
            }
        }
    }
    return max
}

fun checkIsland(grid: Array<IntArray>, i: Int, j: Int): Int{
    if (i < 0 || i >= grid.size || j < 0 || j >= grid[i].size || grid[i][j] == 0) return 0
    grid[i][j] = 0
    var k = 1
    k += checkIsland(grid, i+1,j)
    k += checkIsland(grid, i-1,j)
    k += checkIsland(grid, i,j+1)
    k += checkIsland(grid, i,j-1)
    return k
}

fun moveZeroes(nums: IntArray): Unit {
    var zeroes = 0
    for (i in nums.indices){
        if(nums[i] == 0){
            zeroes++
        }
        if (nums[i] != 0){
            nums[i-zeroes] = nums[i]
        }
    }

    var m = nums.size - 1
    while (zeroes > 0){
        nums[m] = 0
        m--
        zeroes--
    }
}

fun isHappy(n: Int): Boolean {
    var first = n
    var second = n
    do{
        first = numSum(numSum(first))
        second = numSum(second)
    }while(first != second)

    return second == 1
}

fun numSum(k: Int): Int{
    var res = 0
    var num = k
    while (num > 0){
        var sup = num % 10
        res += sup * sup
        num /= 10
    }
    return res
}

fun containsDuplicate(nums: IntArray): Boolean {
    val hs = hashSetOf<Int>()
    for (i in nums){
        if(hs.contains(i)){
            return true
        }else {
            hs.add(i)
        }
    }
    return false
}

fun addDigits(num: Int): Int {
    var sum = 0
    var number = num
    while (number > 0){
        sum += number % 10
        number /= 10
    }
    return if (sum < 10){
        sum
    }else{
        addDigits(sum)
    }
}

fun hammingDistance(x: Int, y: Int): Int {
    var res = 0
    var ourX = x
    var ourY = y
    while (ourX > 0 || ourY > 0){
        res += (ourX % 2) xor (ourY % 2)
        ourX = ourX shr 1
        ourY = ourY shr 1
    }
    return res
}

fun selfDividingNumbers(left: Int, right: Int): List<Int> {
    val arr = arrayListOf<Int>()
    for (i in left..right){
        var flag = true
        var num = i
        while (num > 0){
            var a = num % 10
            if (i % a != 0){
                flag = false
                break
            }
            num /= 10
        }
        if (flag){
            arr.add(i)
        }
    }
    return arr.toList()
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val hm = hashMapOf<Int, Int>()
    val hs = hashSetOf<Int>()
    for (i in arr){
        hm[i] = hm.getOrDefault(i, 0) + 1
    }

    for (j in hm.entries){
        if (!hs.contains(j.value)){
            hs.add(j.value)
        }else{
            return false
        }
    }
        return true
}

fun canBeTypedWords(text: String, brokenLetters: String): Int {
    val list = text.split(" ")
    val set = brokenLetters.toSet()
    var count = 0
    loop@ for (i in list){
        for (j in i){
            if (set.contains(j)){
                continue@loop
            }
        }
        count++
    }
    return count
}

fun minCostToMoveChips(position: IntArray): Int {
    var odd = 0
    var even = 0
    for (i in position) {
        if (i % 2 != 0) odd++
        else even++
    }
    return min(odd,even)
}

fun subtractProductAndSum(n: Int): Int {
    var number = n
    var prod = 1
    var sum = 0
    while (number > 0){
        prod *= number % 10
        sum += number % 10
        number /= 10
    }
    println(prod)
    println(sum)
    return abs(prod - sum)
}

fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
    val arr = arrayListOf<Int>()
    loop@ for (i in matrix.indices){
        var min = Int.MAX_VALUE
        var pos = 0
        for (j in matrix[i].indices){
            if (matrix[i][j] < min){
                min = matrix[i][j]
                pos = j
            }
        }
        for (k in matrix.indices){
            if (k == i){
                continue
            }else{
                if (matrix[k][pos] >= matrix[i][pos]){
                    continue@loop
                }
            }
        }
        arr.add(matrix[i][pos])
    }
    return arr.toList()
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val max = candies.maxOrNull() ?: 0
    candies.forEach {

    }
    return candies.map { it + extraCandies > max }
}

fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
    val keyPlace = when (ruleKey){
        "type" -> 0
        "color" -> 1
        "name" -> 2
        else -> -1
    }

    return items.count {
        it[keyPlace] == ruleValue
    }
}

fun restoreString(s: String, indices: IntArray): String {
    val charArray = arrayOfNulls<Char>(s.length)
    for (i in indices.indices){
        charArray[indices[i]] = s[i]
    }
    return charArray.joinToString("")
}

fun numIdenticalPairs(nums: IntArray): Int {
    val arr1 = IntArray(10) { it/2 }
    println(arr1)
    var count = 0
    val arr = Array<Int>(101, init = {0})

    for (i in arr.indices){
        arr[nums[i]]++
    }

    for (i in 0..100){
        if (arr[i] > 1){
            count += ((arr[i] - 1) * (arr[i]))/2
        }
    }
    return count
}

fun shuffle(nums: IntArray, n: Int): IntArray {
    val returnArr = IntArray(nums.size)
    var first = 0
    var second = n
    for (i in returnArr.indices){
        if ((i + 1) % 2 == 1){
            returnArr[i] = nums[first]
            first++
        }else{
            returnArr[i] = nums[second]
            second++
        }
    }
    return returnArr
}

fun reverse(arr: List<Char>): List<Char?>{
    val size = arr.size
    val myArr = arrayOfNulls<Char>(size)

    for (i in arr.indices){
        myArr[size-1-i] = arr[i]
    }

    return myArr.toList()
}

fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    val arr = arrayOf(0,0)
    for (i in 0..2){
        if(a[i] > b[i]){
            arr[0] = arr[0].plus(1)
        }
        else if (a[i] < b[i]) {arr[1] = arr[1].plus(1)}
    }
    return arr
}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var fs = 0
    var ss = 0
    for (i in arr.indices){
        fs += arr[i][i]
        ss += arr[i][arr.size - 1 - i]
    }
    return abs(fs-ss)
}

fun majorityElement(nums: IntArray): Int {
    val hm = hashMapOf<Int, Int>()
    println(nums.size/2)
    for (i in nums.indices){
        hm[nums[i]] = hm.getOrDefault(nums[i], 0) + 1
        if (hm[nums[i]]!! >= nums.size/2) return nums[i]
    }
    println(nums.size/2)
    return 0
}

fun isPowerOfTwo(n: Int): Boolean {
    return n and (n-1) == 0
}

fun missingNumber(nums: IntArray): Int {
    var result = 0
    for (i in nums.indices){
        result = result xor i
        result = result xor nums[i]
    }
    return result
}

fun reverseString(s: CharArray): Unit {
    val middle = s.size shr 1
    for (i in 0..middle){
        swapChar(s, i, s.size - 1 - i)
    }
}

fun swapChar(s: CharArray, start: Int, end: Int){
    var temp = ' '
    temp = s[start]
    s[start] = s[end]
    s[end] = temp
}

fun countBits(n: Int): IntArray {
    val result = IntArray(n+1){ 0 }
    for (i in result.indices) result[i] = result[i shl 1] + (i and 1) //f[i] = f[i/2] + i%2
    return result
    /*
    val result = IntArray(n+1) { 0 }
    for (i in result.indices){
        var num = i
        var sum = 0
        while (num != 0){
            sum += num % 2
            num /= 2
        }
        result[i] = sum
    }
    return result

     */
}

 fun guessNumber(n:Int):Int {
     var highPoint = n
     var lowPoint = 1
     while(lowPoint < highPoint){
         val middle = lowPoint + (highPoint - lowPoint) / 2
         when (readLine()?.toInt() ?: 0) {
             -1 -> {
                 highPoint = middle
             }
             1 -> {
                 lowPoint = middle + 1
             }
             else -> return middle
         }
     }
     return lowPoint
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val arr = IntArray(26){ 0 }
    for (i in ransomNote.indices){
        arr[ransomNote[i] - 'a']++
    }
    for (j in magazine.indices){
        if (--arr[magazine[j] - 'a'] < 0) return false
    }
    return true
}

fun findComplement(num: Int): Int {
    return num.inv()
}