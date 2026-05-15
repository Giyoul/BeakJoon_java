import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> clothesHashMap = new HashMap<>();
        
        for(String[] cloth : clothes) {
            String name = cloth[0];
            String type = cloth[1];
            
            clothesHashMap.computeIfAbsent(type, K -> new LinkedList())
                .add(name);
        }
        
        int answer = 1;
        for (List<String> value : clothesHashMap.values()) {
            answer *= (value.size() + 1);
        }
        
        return answer - 1;
    }
}