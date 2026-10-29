import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    private boolean[] visited;
    List<Pipe>[] pipeList;
    int answer = 0;
    
    public class Pipe {
        int to;
        int type;
        
        public Pipe(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }
    
    public int solution(int n, int infection, int[][] edges, int k) {
        pipeList = new ArrayList[n + 1];
        visited = new boolean[n+1];
        
        for(int i = 1; i <= n; i++) {
            pipeList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges) {
            pipeList[edge[0]].add(new Pipe(edge[1], edge[2]));
            pipeList[edge[1]].add(new Pipe(edge[0], edge[2]));
        }
        
        visited[infection] = true;
        
        dfs(0, k, n);
        
        return answer;
    }
    
    private void dfs(int depth, int maxOpenCount, int totalSize) {
        int currentCount = countInfected(totalSize);
        answer = Math.max(answer, currentCount);
        
        if(depth == maxOpenCount) return;
        
        for(int pipeType = 1; pipeType <= 3; pipeType++) {
            List<Integer> newlyInfected = spread(pipeType, totalSize);
            dfs(depth + 1, maxOpenCount, totalSize);
            restore(newlyInfected);
        }
    }
    
    private List<Integer> spread(int targetType, int n) {
        List<Integer> newlyInfected = new ArrayList<>();
        Queue<Integer> nodes = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
            if(visited[i]) {
                nodes.add(i);
            }
        }
        
        while(!nodes.isEmpty()) {
            int currentNode = nodes.poll();
            
            for(Pipe pipe : pipeList[currentNode]) {
                if (pipe.type == targetType && !visited[pipe.to]) {
                    visited[pipe.to] = true;
                    newlyInfected.add(pipe.to);
                    nodes.add(pipe.to);
                }
            }
        }
        
        return newlyInfected;
    }
    
    private void restore(List<Integer> newlyInfected) {
        for (int node : newlyInfected) {
            visited[node] = false;
        }
    }
    
    private int countInfected(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) count++;
        }
        return count;
    }
}