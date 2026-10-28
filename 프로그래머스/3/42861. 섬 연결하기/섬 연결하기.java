import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] i) -> i[2]));
        parent = new int[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int[] cost : costs) {
            pq.add(cost);
        }
        
        int edgeCount = 0;
        while(!pq.isEmpty() && edgeCount < n-1) {
            int[] current = pq.poll();
            int nodeA = current[0], nodeB = current[1], cost = current[2];
            
            if(find(nodeA) != find(nodeB)) {
                union(nodeA, nodeB);
                edgeCount++;
                answer += cost;
            }
        }
        
        return answer;
    }
    
    private int find(int node) {
        if(parent[node] == node) return node;
        return parent[node] = find(parent[node]);
    }
    
    private void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}