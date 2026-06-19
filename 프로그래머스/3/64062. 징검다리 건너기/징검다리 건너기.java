class Solution {
    public int solution(int[] stones, int k) {
        int start = 0;
        int end = 200_000_000;
        int answer = 0;
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if(binarySearch(stones, k, mid)) {
                answer = mid;
                start = mid + 1;
            } else { 
                end = mid;
            }
        }
        
        return answer;
    }
    
    private boolean binarySearch(int[] stones, int k, int mid) {
        int count = 0;
        for(int stone : stones) {
            if(stone < mid) count++;
            else count = 0;
            
            if(count == k) return false;
        }
        return true;
    }
}