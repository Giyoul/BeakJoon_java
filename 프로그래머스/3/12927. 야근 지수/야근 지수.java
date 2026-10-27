import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works) {
            pq.add(work);
        }
        
        while(n > 0){
            int biggest = pq.poll();
            
            if(biggest == 0) return 0;
            
            pq.add(biggest - 1);
            n--;
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            long num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
}