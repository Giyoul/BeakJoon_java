import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<String> allRoutes;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        allRoutes = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(allRoutes);
        
        return allRoutes.get(0).split(" ");
    }
    
    public void dfs(String current, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            allRoutes.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}