class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = 400_000_000_000_000L;
        long answer = right;
        
        int cityNum = g.length;
        
        while(left <= right) {
            long mid = (left + right) / 2;
            
            long totalGold = 0;
            long totalSilver = 0;
            long totalMineral = 0;
            
            for(int i = 0; i < cityNum; i++) {
                long currentGold = g[i];
                long currentSilver = s[i];
                long currentWeight = w[i];
                long currentTime = t[i];
                
                long moveCount = mid / (currentTime * 2);
                if (mid % (currentTime * 2) >= currentTime) {
                    moveCount++;
                }
                
                long maxTransportWeight = moveCount * currentWeight;
                
                totalGold += Math.min(currentGold, maxTransportWeight);
                totalSilver += Math.min(currentSilver, maxTransportWeight);
                totalMineral += Math.min(currentGold + currentSilver, maxTransportWeight);
            }
            
            if(totalGold >= a && totalSilver >= b && totalMineral >= a + b) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}