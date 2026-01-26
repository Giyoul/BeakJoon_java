import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val del = readLine().toInt()

    val graph = Array(n){ mutableListOf<Int>() }
    var root = -1

    repeat(n) {
        val cur = st.nextToken().toInt()
        if (cur == -1) {
            root = it
        } else {
            if (it != del) {
                graph[cur].add(it)
            }
        }
    }

    if (root == del) {
        println(0)
        return
    }

    println(countLeafNodes(root, graph))
}

fun countLeafNodes(current: Int, graph: Array<MutableList<Int>>): Int {
    if (graph[current].isEmpty()) return 1

    var count = 0
    for(next in graph[current]){
        count += countLeafNodes(next, graph)
    }
    return count
}