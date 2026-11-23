import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cards1Queue = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cards2Queue = new LinkedList<>(Arrays.asList(cards2));
        
        for(String word : goal) {
            if(word.equals(cards1Queue.peek())){
                cards1Queue.remove();
            } else if(word.equals(cards2Queue.peek())){
                cards2Queue.remove();
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}