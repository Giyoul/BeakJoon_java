import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val del = readLine().toInt()
    var root = -1
    var delParent = -1

    val graph = Array(n){ mutableListOf<Int>() }

    repeat(n) {
        val cur = st.nextToken().toInt()
        if (cur == -1) {
            root = it
            return@repeat
        }
        if (it == del) {
            delParent = cur
        }
        graph[cur].add(it)
    }

    val q = ArrayDeque<Int>()
    q.add(del)
    if(delParent != -1) graph[delParent].remove(del)

    while (q.isNotEmpty()) {
        val idx = q.removeFirst()
        if (graph[idx].isNotEmpty()) {
            for (sibling in graph[idx]) {
                q.add(sibling)
            }
            graph[idx].clear()
        }
    }

    var count = 0
    val deq = ArrayDeque<Int>()
    deq.add(root)

    if (del != root) {
        while (deq.isNotEmpty()) {
            val idx =  deq.removeFirst()
            if (graph[idx].isEmpty()) {
                count++
                continue
            } else {
                for (sibling in graph[idx]) {
                    deq.add(sibling)
                }
            }
        }
    }

    println(count)
}