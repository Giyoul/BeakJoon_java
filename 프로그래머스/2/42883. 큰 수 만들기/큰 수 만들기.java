import java.lang.StringBuilder;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int length = number.length() - k;
        int start = 0;
        
        for(int j = 0; j < length; j++) {
            int max = '0' - 1;
            int maxIdx = start;
            int end = k + j;
            
            for(int i = start; i <= end; i++) {
                if (max < number.charAt(i)) {
                    max = number.charAt(i);
                    maxIdx = i;
                }
            }
            answer.append((char)max);
            start = maxIdx + 1;
            
            if (start - answer.length() == k) {
                answer.append(number.substring(start));
                break;
            }
        }
        
        return answer.toString();
    }
}