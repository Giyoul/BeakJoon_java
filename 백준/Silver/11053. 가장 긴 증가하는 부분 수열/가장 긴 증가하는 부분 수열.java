import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] element = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = 1;
        element[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int token = Integer.parseInt(st.nextToken());
            element[i] = token;
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(token > element[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[n - 1]);
    }
}
