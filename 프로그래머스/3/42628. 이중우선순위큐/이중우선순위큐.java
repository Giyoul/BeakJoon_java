import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        
        for(String str : operations) {
            String[] splitedStr = str.split(" ");
            String command = splitedStr[0];
            int value = Integer.parseInt(splitedStr[1]);
            
            if(command.equals("I")) {
                tMap.put(value, tMap.getOrDefault(value, 0) + 1);
            } else if (!tMap.isEmpty()) {
                int targetKey = (value == 1) ? tMap.lastKey() : tMap.firstKey(); 
                
                if (tMap.get(targetKey) == 1) {
                    tMap.remove(targetKey);
                } else {
                    tMap.put(targetKey, tMap.get(targetKey) - 1);
                }
            }
        }
        
        if(tMap.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{tMap.lastKey(), tMap.firstKey()};
    }
}
