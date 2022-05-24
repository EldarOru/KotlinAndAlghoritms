fun main() {
    println(getMinOperations(arrayOf(5,3)).toList())
    println(deleteProducts(arrayOf(4,1,2,3,4),2))

    val list = mutableListOf('5','+','1','+','(','3','-','1',')')
    for (i in 0 until list.size){
        if (list[i] == '(') println("start $i")
        if (list[i] == ')') println("end $i")
    }
    println(list.subList(4,9).toString())
    list.subList(4,9).clear()
    list.add(4, '2')
    println(list.toString())
}

fun getMinOperations(kValues: Array<Long>): Array<Int> {
    val arr = Array(kValues.size){0}
    for (i in kValues.indices){
        var count = 0
        var num = kValues[i]
        while (num != 0L){
            if (num % 2 == 0L){
                num /= 2
                count ++
            }else{
                num -= 1
                count ++
            }
        }
        arr[i] = count
    }
    return arr
}

fun deleteProducts(ids: Array<Int>, m: Int): Int {
    val hm = hashMapOf<Int, Int>()
    for (i in ids){
        if (hm.keys.contains(i)){
            hm[i] = hm[i]!!.plus(1)
        }else{
            hm[i] = 1
        }
    }
    val res = hm.toList().sortedBy { (_, value) -> value}.toMap()
    var result = 0
    var del = m
    for (v in res.keys){
        if (res[v]!!.minus(del) <= 0){
            del -= res[v]!!
            println(del)
        }else result ++
    }
    return result
}

