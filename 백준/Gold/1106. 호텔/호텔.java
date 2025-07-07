import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[target + 101];
        Arrays.fill(dp, 100000000);
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < target + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = target; i < target + 101; i++){
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}