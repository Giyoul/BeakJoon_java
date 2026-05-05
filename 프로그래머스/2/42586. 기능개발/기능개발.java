import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> speedDeque = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            deque.add(progresses[i]);
            speedDeque.add(speeds[i]);
        }
        
        List<Integer> answerList = new ArrayList();
        
        while(!deque.isEmpty()) {
            int repeat = deque.size();
            for(int i = 0; i < repeat; i++) {
                int node = deque.remove();
                int speed = speedDeque.remove();
                
                deque.add(node + speed);
                speedDeque.add(speed);
            }
            
            if(!deque.isEmpty() && deque.peek() >= 100) {
                int count = 0;
                
                while(!deque.isEmpty() && deque.peek() >= 100) {
                    deque.remove();
                    speedDeque.remove();
                    count++;
                }
                answerList.add(count);
            }
        }
        
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}