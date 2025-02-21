import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] map;
    public static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 1000000;

        for (int i = 0; i < 3; i++) {
            dp = new int[n][3];
            dp[0][i] = map[0][i];
            for (int j = 0; j < 3; j++) {
                if(j != i){
                    dp[0][j] = 1000001;
                }
            }

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + map[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + map[j][1];
                dp[j][2] = Math.min(dp[j-1][1], dp[j-1][0]) + map[j][2];
            }

            for (int j = 0; j < 3; j++) {
                if(j != i){
                    ans = Math.min(ans, dp[n-1][j]);
                }
            }
        }

        System.out.println(ans);

    }
}