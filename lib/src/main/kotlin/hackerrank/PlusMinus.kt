package hackerrank

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>) {
    val positive = mutableListOf<Int>()
    val negative = mutableListOf<Int>()
    val zeros = mutableListOf<Int>()
    for(elem in arr) {
        if(elem > 0) positive.add(elem)
        else if(elem < 0) negative.add(elem)
        else zeros.add(elem)
    }
    val total = positive.size + negative.size + zeros.size
    println(format(positive.size / total.toDouble()))
    println(format(negative.size / total.toDouble()))
    println(format(zeros.size / total.toDouble()))
}

private fun format(number: Double): String = String.format("%.6f", number)

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    plusMinus(arr)
}
