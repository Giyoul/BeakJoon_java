
fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val str = readLine().split(" ").map { it.toInt() }.toIntArray()

    data class Node(val count: Int, val curStr: String)

    fun bfs(): Int {
        val sortStr = str.sortedArray().joinToString("")
        val set = HashSet<String>()
        val q = ArrayDeque<Node>()
        q.add(Node(0, str.joinToString("")))

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            if (sortStr == cur.curStr) {
                return cur.count
            }

            if(set.contains(cur.curStr)) continue
            set.add(cur.curStr)

            var left = 0
            var right = k
            while (right <= n) {
                val head = cur.curStr.substring(0, left)
                val body = cur.curStr.substring(left, right).reversed()
                val tail = cur.curStr.substring(right, n)

                val nextStr = head + body + tail
                q.add(Node(cur.count + 1, nextStr))

                left++
                right++
            }
        }

        return -1
    }

    println(bfs())
}