import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] dp;
    static int[] mem;
    static int[] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[10001];
        cost = new int[101];
        mem = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 10000; j >= 0; j--) {
                if(j >= cost[i]) dp[j] = Math.max(dp[j], dp[j-cost[i]] + mem[i]);
            }
        }

        int cost = 0;

        while(dp[cost] < m) cost++;

        System.out.println(cost);
    }
}