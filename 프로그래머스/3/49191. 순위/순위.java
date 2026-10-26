class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] wins = new boolean[n + 1][n + 1];
        int answer = 0;
        
        for(int[] result : results) {
            wins[result[0]][result[1]] = true;
        }
        
        for(int via = 1; via <= n; via++) {
            for(int start = 1; start <= n; start++) {
                for(int end = 1; end <= n; end++) {
                    if(wins[start][via] && wins[via][end]) {
                        wins[start][end] = true;
                    }
                }
            }
        }
        
        for(int target = 1; target <= n; target++) {
            int winCount = 0;
            int loseCount = 0;
            for(int enemy = 1; enemy <= n; enemy++) {
                if(wins[target][enemy]) winCount++;
                if(wins[enemy][target]) loseCount++;
            }
            
            if(winCount + loseCount == n-1) answer++;
        }
        
        return answer;
    }
}