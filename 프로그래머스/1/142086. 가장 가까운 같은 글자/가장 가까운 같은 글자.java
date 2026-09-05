import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> indexMap = new HashMap();
        int[] answer = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            char splitedChar = s.charAt(i);
            if(indexMap.containsKey(splitedChar)) {
                answer[i] = i - indexMap.get(splitedChar);
            } else {
                answer[i] = -1;
            }
            indexMap.put(splitedChar, i);
        }
        
        return answer;
    }
}