fun main() {
    val numbers = intArrayOf(2, 7, 4, 5, 11, 15, 3)
    val target = 9
    println("SumOfTwoNumbers: ${SumOfTwoNumbers(numbers, target).joinToString("; ") { it.joinToString(", ") }}")
    var resultData=SumOfTwoNumbers(numbers, target)
    var resultData1=SumOfTwoNumbers1(numbers,target)
    var resultData2=SumOfTwoNumbers2(numbers,target)
    for(pair in resultData2){
        println("Pair indices: ${pair.joinToString(", ")}")
}
}
fun SumOfTwoNumbers(str: IntArray, target: Int): List<IntArray> {
    var result=mutableListOf<IntArray>()
    for (i in str.indices) {
        println("i: ${str[i]}") 
        for (j in i + 1 until str.size) {
            println("j: ${str[j]}") // Access the actual element at index j
            if (str[i] + str[j] == target) {
                result.add(intArrayOf(i, j))
            }
        }
    }
    return result
}

fun SumOfTwoNumbers1(str:IntArray,target:Int):List<IntArray>{
    var results=mutableListOf<IntArray>()
    var numMap=mutableMapOf<Int,Int>()
    for(i in str.indices){
        val complement=target - str[i]
        if(numMap.containsKey(complement)){
            results.add(intArrayOf(numMap[complement]!!,i))
        }
        numMap[str[i]]=i
    }
    return results
}

fun SumOfTwoNumbers2(str:IntArray, target:Int): List<IntArray> {
    var results = mutableListOf<IntArray>()
    var left = 0
    var right = str.size - 1

    while (left < right) {
        val sum = str[left] + str[right]
        if (sum == target) {
            results.add(intArrayOf(left, right))
            left++
            right--
        } else if (sum < target) {
            left++
        } else {
            right--
        }
    }
    return results
}
