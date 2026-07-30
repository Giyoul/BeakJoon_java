import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> replacedChar = new HashMap<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            if (skip.contains(c + "")) continue;
            
            char current = c;
            int count = 0;
            
            while (count < index) {
                if (current == 'z') {
                    current = 'a';
                } else {
                    current = (char) (current + 1);
                }
                
                if (!skip.contains(current + "")) {
                    count++;
                }
            }
            
            replacedChar.put(c, current);
        }
        
        for (int i = 0; i < s.length(); i++) {
            sb.append(replacedChar.get(s.charAt(i)));
        }
        
        return sb.toString();
    }
}