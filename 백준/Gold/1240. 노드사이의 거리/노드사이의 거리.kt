import java.util.StringTokenizer

data class Node(val to: Int, val distance: Int)

fun main() = with(System.`in`.bufferedReader()) {
    // n, m 입력 받기
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    
    val tree = Array(n + 1) { mutableListOf<Node>() }
    val sb = StringBuilder()

    // 트리 구조 입력 받기
    repeat(n - 1) {
        st = StringTokenizer(readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val distance = st.nextToken().toInt()
        
        tree[from].add(Node(to, distance))
        tree[to].add(Node(from, distance))
    }

    // 쿼리 처리 (BFS)
    repeat(m) {
        st = StringTokenizer(readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()

        val visited = BooleanArray(n + 1)
        val q = ArrayDeque<Node>()
        q.add(Node(from, 0))

        // 시작점도 방문 처리를 해주는 것이 안전해요! 
        // (기존 로직 유지를 위해 내부는 건드리지 않았습니다)
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            visited[cur.to] = true
            
            for (nextNode in tree[cur.to]) {
                if (visited[nextNode.to]) continue
                if (nextNode.to == to) {
                    sb.append("${cur.distance + nextNode.distance}\n")
                    return@repeat
                }
                q.add(Node(nextNode.to, cur.distance + nextNode.distance))
            }
        }
    }

    print(sb)
}