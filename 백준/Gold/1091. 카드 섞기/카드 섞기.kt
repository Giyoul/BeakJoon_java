
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val s = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val card = IntArray(n){it % 3}

    var count = 0

    while (!card.contentEquals(p)) {
        val temp = card.clone()

        for (i in 0 until n) {
            card[i] = temp[s[i]]
        }

        if (count > 120119) {
            println("-1")
            return
        }
        count++
    }

    println(count)
}