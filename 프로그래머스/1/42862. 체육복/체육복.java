import java.util.stream.Collectors;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> reserveSet = new HashSet<>();
        for(int reser : reserve) {
            reserveSet.add(reser);
        }
        
        Set<Integer> lostSet = new HashSet<>();
        for(int lostNum : lost) {
            if (reserveSet.contains(lostNum)) {
                reserveSet.remove(lostNum);
            } else {
                lostSet.add(lostNum);
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(lostSet.contains(i)){
                if(reserveSet.contains(i - 1)){
                    reserveSet.remove(i - 1);
                    answer++;
                    continue;
                }
                if(reserveSet.contains(i + 1)){
                    reserveSet.remove(i + 1);
                    answer++;
                    continue;
                }
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}