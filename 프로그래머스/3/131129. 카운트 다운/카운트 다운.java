import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    static class ScoreInfo {
        int score;
        int isSingleOrBull;
        
        public ScoreInfo(int score, int isSingleOrBull) {
            this.score = score;
            this.isSingleOrBull = isSingleOrBull;
        }
    }
    
    public int[] solution(int target) {
        Map<Integer, Integer> scoreMap = new HashMap<>();
        
        for(int i = 1; i <= 20; i++) {
            scoreMap.put(i, 1);
        }
        scoreMap.put(50, 1);
        
        for(int i = 2; i <= 40; i += 2) {
            scoreMap.computeIfAbsent(i, k -> 0);
        }
        
        for(int i = 3; i <= 60; i += 3) {
            scoreMap.computeIfAbsent(i, k -> 0);
        }
        
        List<ScoreInfo> scoreList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            scoreList.add(new ScoreInfo(entry.getKey(), entry.getValue()));
        }
        
        int[][] dp = new int[target + 1][2];
        
        final int INF = 1000000;
        for(int i = 1; i <= target; i++) { 
            dp[i][0] = INF;
            dp[i][1] = 0;
        }
        
        dp[0][0] = 0;
        dp[0][1] = 0;
        
        for(int i = 1; i <= target; i++) {
            for(ScoreInfo scoreInfo : scoreList) {
                if(i >= scoreInfo.score) {
                    int currentScore = dp[i - scoreInfo.score][0];
                    int currentSingle = dp[i - scoreInfo.score][1];
                    
                    if(currentScore != INF) {
                        int nextScore = currentScore + 1;
                        int nextSingle = currentSingle + scoreInfo.isSingleOrBull;
                        
                        if(nextScore < dp[i][0]) {
                            dp[i][0] = nextScore;
                            dp[i][1] = nextSingle;
                        }
                        
                        if(nextScore == dp[i][0]) {
                            if(nextSingle > dp[i][1]) {
                                dp[i][1] = nextSingle;
                            }
                        }
                    }
                }
            }
        }
        
        return dp[target];
    }
}