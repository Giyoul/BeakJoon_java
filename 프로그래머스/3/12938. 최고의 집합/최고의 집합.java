import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int mid = s / n;
        int left = s % n;
        
        for(int i = 0; i < n - left; i++) {
            answer[i] = mid;
        }
        for(int i = n - left; i < n; i++) {
            answer[i] = mid+1;
        }
        
        return answer;
    }
}