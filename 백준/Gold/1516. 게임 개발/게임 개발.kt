import java.io.StreamTokenizer
import kotlin.math.max

lateinit var cost : IntArray
lateinit var need: Array<MutableList<Int>>

fun main() = with(StreamTokenizer(System.`in`.bufferedReader())) {
    fun StreamTokenizer.nextInt(): Int {
        nextToken()
        return nval.toInt()
    }

    val sb = StringBuilder()
    val n = nextInt()
    cost = IntArray(n + 1)
    need = Array(n+1){ mutableListOf() }

    repeat(n) {
        val curCost = nextInt()
        cost[it + 1] = curCost
        while (true) {
            val needNode = nextInt()
            if(needNode == -1) break
            need[it + 1].add(needNode)
        }
    }

    repeat(n) {
        if (need[it + 1].isNotEmpty()) {
            updateTime(it + 1)
        }
        sb.append(cost[it + 1]).append("\n")
    }
    println(sb)
}

fun updateTime(idx: Int): Int {
    if(need[idx].isEmpty()) return cost[idx]
    var maxTime = -1
    for (node in need[idx]) {
        maxTime = max(maxTime, updateTime(node))
    }
    need[idx].clear()
    cost[idx] = cost[idx] + maxTime
    return cost[idx]
}

