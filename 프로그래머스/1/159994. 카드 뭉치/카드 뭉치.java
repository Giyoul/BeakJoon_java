import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Deque<String> card1Deque = new ArrayDeque();
        Deque<String> card2Deque = new ArrayDeque();
        
        for(String card : cards1) {
            card1Deque.add(card);
        }
        for(String card : cards2) {
            card2Deque.add(card);
        }
        
        String answer = "Yes";
        for(String goalString : goal) {
            if(goalString.equals(card1Deque.peek())) {
                card1Deque.poll();
            } else if(goalString.equals(card2Deque.peek())) {
                card2Deque.poll();
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}