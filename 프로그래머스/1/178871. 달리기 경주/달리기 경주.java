import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> ranking = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            ranking.put(players[i], i);
        }
        
        for(String name : callings) {
            int nameRank = ranking.get(name);
            String targetName = players[nameRank - 1];
            
            ranking.put(name, nameRank - 1);
            ranking.put(targetName, nameRank);
            
            players[nameRank - 1] = name;
            players[nameRank] = targetName;
        }
        
        return players;
    }
}