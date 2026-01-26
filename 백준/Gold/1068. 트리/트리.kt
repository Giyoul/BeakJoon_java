import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val delNode = readLine().toInt()
    
    val graph = Array(n) { mutableListOf<Int>() }
    var root = -1

    repeat(n) { i ->
        val parent = st.nextToken().toInt()
        if (parent == -1) {
            root = i
        } else {
            if (i != delNode) {
                graph[parent].add(i)
            }
        }
    }

    if (root == delNode) {
        println(0)
        return
    }

    println(countLeafNodes(root, graph))
}

fun countLeafNodes(current: Int, graph: Array<MutableList<Int>>): Int {
    if (graph[current].isEmpty()) return 1
    
    var count = 0
    for (next in graph[current]) {
        count += countLeafNodes(next, graph)
    }
    return count
}