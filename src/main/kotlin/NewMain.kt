import java.util.*

fun main() {
    println(binarySearch(Array(100) { it + 1 }, 25))
    println(vyborkaSort(arrayOf(1, 3, 5, 2, 4)).toList().toString())
    println(myFactorial(4))
    println(greatestCommonDivisor(Pair(539, 60)))

    var time = System.currentTimeMillis()
    println(quickSort(listOf(2, 4, 7, 3, 6, 9, 5, 1, 0)))
    println("Sort with filter: ${System.currentTimeMillis() - time}")

    println(bracketEqual("{[()]}()"))
    println(bracketEqual("abcd"))

    time = System.currentTimeMillis()
    println(trueQuickSort(arrayOf(2, 4, 7, 3, 6, 9, 5, 1, 0) ).toList().toString())
    println("Sort without filter: ${System.currentTimeMillis() - time}")

    val arr1 = arrayListOf(1,2,3)
    val arr2 = arr1
    arr2[0] = 5
    println(arr1[0])
    println(arr2[0])
}

fun binarySearch(array: Array<Int>, goal: Int): Int? {
    var countOfSteps = 0
    var lowPoint = 0
    var highPoint = array.size - 1
    while (lowPoint <= highPoint) {
        countOfSteps++
        println(countOfSteps)
        val mid = (lowPoint + highPoint) / 2
        val guess = array[mid]
        if (guess == goal) return guess
        if (goal > guess) lowPoint = mid + 1
        else highPoint = mid - 1
    }
    return null
}

fun vyborkaSort(array: Array<Int>): Array<Int> {
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            if (array[i] > array[j]) {
                array.swap(i, j)
            }
        }
    }
    return array
}

fun Array<Int>.swap(i: Int, j: Int) {
    val num = this[i]
    this[i] = this[j]
    this[j] = num
}

fun reverse(arr: List<Char>): List<Char?> {
    val size = arr.size
    val myArr = arrayOfNulls<Char>(size)

    for (i in arr.indices) {
        myArr[size - 1 - i] = arr[i]
    }
    return myArr.toList()
}

fun myFactorial(int: Int): Int {
    return if (int == 1) 1
    else int * myFactorial(int - 1)
}

fun greatestCommonDivisor(numbers: Pair<Int, Int>): Pair<Int, Int> {
    return if (numbers.first == 0 || numbers.second == 0) numbers
    else greatestCommonDivisor(Pair(numbers.second, numbers.first % numbers.second))
}

//Разделяй и властвуй
/*
Решение задачи методом «разделяй и властвуй ~ состоит из двух шагов:
1. Сначала определяется базовый случай. Это должен быть простейший случай из всех возможных.
2. Задача делится или сокращается до тех пор, пока не будет сведена к базовому случаю.
 */
fun quickSort(items: List<Int>): List<Int> {
    //базовый случай
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count() / 2]

    val less = items.filter { it < pivot }

    val equal = items.filter { it == pivot }

    val more = items.filter { it > pivot }

    return quickSort(less) + equal + quickSort(more)
    //в худшем случае n^2, в среднем n*log(n)
}

fun trueQuickSort(items: Array<Int>, start: Int = 0, end: Int = items.size-1): Array<Int> {

    if (start < end) {
        val divideIndex = myPartition(items, start, end)

        trueQuickSort(items, start, divideIndex-1)

        trueQuickSort(items, divideIndex, end)
    }
    return items
}

fun myPartition(items: Array<Int>, start: Int, end: Int): Int {
    var rightIndex = end
    var leftIndex = start

    val pivot = items[start]

    while (leftIndex <= rightIndex) {
        while (items[leftIndex] < pivot) {
            leftIndex++
        }
        while (items[rightIndex] > pivot) {
            rightIndex--
        }
        if (leftIndex <= rightIndex){
            items.swap(rightIndex, leftIndex)
            leftIndex++
            rightIndex--
        }
    }
    return leftIndex
}

fun bracketEqual(str: String): Boolean {

    if (str.isEmpty()) return false

    val checkMap = hashMapOf('[' to ']', '{' to '}', '(' to ')')
    val stack = Stack<Char>()

    for (i in str) {
        if (checkMap.containsKey(i)) stack.add(i)
        else if (!checkMap.containsValue(i)) continue
        else if (stack.isEmpty()) return false
        else if (checkMap[stack.pop()] != i) return false
    }

    return stack.isEmpty()

}

/*
public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong

    // Инициализируем переменную, которая будет отвечать за количество нужных изменений
    int changesCount = 0;

    // Создаем регулярные выражения для поиска паттерна в пароле
    Matcher number = Pattern.compile("[0123456789]").matcher(password);
    Matcher upCase = Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]").matcher(password);
    Matcher lowerCase = Pattern.compile("[abcdefghijklmnopqrstuvwxyz]").matcher(password);
    Matcher special = Pattern.compile("[!@#$%^&*()-/+]").matcher(password);

    // Если заданного паттерна нету в пароле, то увеличиваем число изменений
    if(!number.find())
        changesCount++;
    if(!upCase.find())
        changesCount++;
    if(!lowerCase.find())
        changesCount++;
    if(!special.find())
        changesCount++;

    /*
    Если длина пароля и число изменений меньше минимальной длины пароля, то добавляем изменения, чтобы пароль           стал нужной длины
    */
    if(n+changesCount < 6){
        changesCount+= 6-n-changesCount;
    }

    //Возвращаем число изменений
    return changesCount;
}
 */


