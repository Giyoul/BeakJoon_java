import java.util.Arrays;

class Solution{
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int count = 0;
        int end = -30_001;
        for(int[] route : routes) {
            if(route[0] > end) {
                count++;
                end = route[1];
            }
        }
            
        return count;
    }
}