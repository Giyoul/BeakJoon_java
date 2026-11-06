import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int ans = 0;
        int pos = 0;
        
        for(int[] target : targets) {
            if(target[0] >= pos){
                ans++;
                pos = target[1];
            } else {
                continue;
            }
        }
        
        return ans;
    }
}