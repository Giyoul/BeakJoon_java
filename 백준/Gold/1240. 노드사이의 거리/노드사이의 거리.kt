data class Node(val to: Int, val distance: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val tree = Array(n+1){ mutableListOf<Node>() }
    val sb = StringBuilder()

    repeat(n - 1) {
        val (from, to, distance) = readLine().split(" ").map { it.toInt() }
        tree[from].add(Node(to, distance))
        tree[to].add(Node(from, distance))
    }

    repeat(m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }

        val visited = BooleanArray(n+1)
        val q = ArrayDeque<Node>()
        q.add(Node(from, 0))

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            visited[cur.to] = true
            for (nextNode in tree[cur.to]) {
                if(visited[nextNode.to]) continue
                if (nextNode.to == to) {
                    sb.append("${cur.distance + nextNode.distance}\n")
                    return@repeat
                }
                q.add(Node(nextNode.to, cur.distance + nextNode.distance))
            }
        }
    }

    println(sb)
}