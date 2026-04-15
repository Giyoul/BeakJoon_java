import java.util.*;

public class Solution {
    public int[] solution(int []arr) {    
        Deque<Integer> deque = new ArrayDeque();
        deque.addLast(-1);
        
        for(int num : arr) {
            if(deque.getLast() != num){
                deque.addLast(num);
            }
        }
        
        deque.removeFirst();
        
        int[] answer = deque.stream()
            .mapToInt(Integer::intValue)
            .toArray();

        return answer;
    }
}