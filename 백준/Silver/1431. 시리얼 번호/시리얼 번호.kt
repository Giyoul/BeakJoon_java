
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<String>()
    repeat(n) { list.add(readLine())}

    val customComparator = Comparator<String> { a, b ->
        if (a.length != b.length) {
            return@Comparator a.length - b.length
        }

        val sumA = a.filter { it.isDigit() }.sumOf { it.digitToInt() }
        val sumB = b.filter { it.isDigit() }.sumOf { it.digitToInt() }

        if (sumA != sumB) {
            return@Comparator sumA - sumB
        }

        return@Comparator a.compareTo(b)
    }

    val sortedList = list.sortedWith(customComparator)

    println(sortedList.joinToString("\n"))
}
