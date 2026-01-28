import java.util.StringTokenizer

data class Node(val to: Int, val distance: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val tree = Array(n + 1) { mutableListOf<Node>() }
    val sb = StringBuilder()

    repeat(n - 1) {
        st = StringTokenizer(readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val dist = st.nextToken().toInt()
        tree[from].add(Node(to, dist))
        tree[to].add(Node(from, dist))
    }

    repeat(m) {
        st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        sb.append("${getDistance(start, end, n, tree)}\n")
    }

    print(sb)
}

fun getDistance(start: Int, end: Int, n: Int, tree: Array<MutableList<Node>>): Int {
    if (start == end) return 0

    val visited = BooleanArray(n + 1)
    val q = ArrayDeque<Node>()

    q.add(Node(start, 0))
    visited[start] = true

    while (q.isNotEmpty()) {
        val (curPos, curDist) = q.removeFirst()

        for (next in tree[curPos]) {
            if (!visited[next.to]) {
                val totalDist = curDist + next.distance

                if (next.to == end) return totalDist

                visited[next.to] = true
                q.add(Node(next.to, totalDist))
            }
        }
    }
    return 0
}