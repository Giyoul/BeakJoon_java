import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue();
        for(String time : timetable) {
            String[] splitedTime = time.split(":");
            pq.add(0 + Integer.parseInt(splitedTime[0]) * 60 + Integer.parseInt(splitedTime[1]));
        }
        
        int shuttleTime = 60 * 9;
        int lastCrewTime = 0;
        int crewCount = 0;
        
        for(int i = 0; i < n; i++) {
            crewCount = 0;
            
            while(!pq.isEmpty() && pq.peek() <= shuttleTime && crewCount < m) {
                lastCrewTime = pq.poll();
                crewCount++;
            }
            
            if(i < n - 1) {
                shuttleTime += t;
            }
        }
        
        int conTime = 0;
        if(crewCount < m) {
            conTime = shuttleTime;
        } else {
            conTime = lastCrewTime - 1;
        }
        
        return String.format("%02d:%02d", conTime / 60, conTime % 60);
    }
}