class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for(int i = 0; i < money.length; i++) {
            int currentMoney = money[i];
            for(int j = currentMoney; j <= n; j++) {
                dp[j] += dp[j - currentMoney];
                dp[j] %= 1000000007;
            }
        }
        
        return dp[n];
    }
}