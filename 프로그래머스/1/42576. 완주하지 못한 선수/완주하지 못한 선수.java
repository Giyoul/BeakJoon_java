import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap();
        
        for(String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        for(String name : completion) {
            if(map.get(name) == 1) {
                map.remove(name);
            } else {
                map.replace(name, map.get(name) - 1);
            }
        }
        
        return map.keySet().iterator().next();
    }
}