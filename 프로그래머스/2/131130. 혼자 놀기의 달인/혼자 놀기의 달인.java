import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    boolean[] visited;
    Map<Integer, Integer> map;
    
    public int solution(int[] cards) {
        map = new HashMap<>();
        
        int size = cards.length;
        for(int i = 0; i < size; i++) {
            map.put(i+1, cards[i]);
        }
        
        visited = new boolean[size + 1];
        int first = 0;
        int second = -1;
        
        for(int i = 1; i <= size; i++) {
            if(!visited[i]) {
                int count = dfs(0, i);
                
                if(count >= first) {
                    second = first;
                    first = count;
                } else if(count > second) {
                    second = count;
                }
            }
        }
        
        return first * second;
    }
    
    private int dfs(int count, int currentNode) {
        if(!visited[currentNode]) {
            visited[currentNode] = true;
            return dfs(count + 1, map.get(currentNode));
            
        }
        
        return count;
    }
}
