import java.io.StreamTokenizer

lateinit var count: IntArray

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun StreamTokenizer.nextInt(): Int {
        nextToken()
        return nval.toInt()
    }

    var end = nextInt()
    var start = 1
    var digit = 1
    count = IntArray(10){ 0 }

    fun countNum(num: Int, digit: Int) {
        var tmpNum = num
        while (tmpNum > 0) {
            count[tmpNum % 10] += digit
            tmpNum /= 10
        }
    }

    while (start <= end) {
        while (start % 10 != 0 && start <= end) {
            countNum(start, digit)
            start++
        }

        while (end % 10 != 9 && start <= end) {
            countNum(end, digit)
            end--
        }

        if(start > end) break

        start /= 10
        end /= 10

        repeat(10) {
            count[it] += (end - start + 1) * digit
        }

        digit *= 10
    }

    println(count.joinToString(" "))
}