import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue();
        for(int value : scoville) {
            pq.add(value);
        }
        
        while(true) {
            int first = pq.poll();
            
            if(first >= K) break;
            if(pq.isEmpty()) {
                answer = -1;
                break;
            }
            
            int second = pq.poll();
            pq.offer(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}