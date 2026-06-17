import java.lang.StringBuilder;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for(int i = 0; i < s.length; i++){
            StringBuilder targetString = new StringBuilder();
            StringBuilder currentString = new StringBuilder();
            
            for(int j = 0; j < s[i].length(); j++) {
                currentString.append(s[i].charAt(j));
                int len = currentString.length();
                if(len >= 3 && currentString.charAt(len-3) == '1' 
                            && currentString.charAt(len-2) == '1' 
                            && currentString.charAt(len-1) == '0') {
                    targetString.append("110");
                    currentString.delete(len - 3, len);
                }
            }
            
            int lastIndexOfZero = currentString.lastIndexOf("0");
            if(lastIndexOfZero == -1) {
                currentString.insert(0, targetString);
            } else {
                currentString.insert(lastIndexOfZero + 1, targetString);
            }
            answer[i] = currentString.toString();
        }
        
        return answer;
    }
}