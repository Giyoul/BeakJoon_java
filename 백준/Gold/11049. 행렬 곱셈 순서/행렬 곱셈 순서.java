import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        arr = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for(int d=1;d<N;d++) {
            for(int i=0;i+d<N;i++) {
                int min = Integer.MAX_VALUE;
                for(int k=i;k<i+d;k++) {
                    int val = dp[i][k]+dp[k+1][i+d] + arr[i][0] * arr[k][1] * arr[i+d][1];
                    min = Math.min(min, val);
                }
                dp[i][i+d] = min;
            }
        }

        System.out.println(dp[0][N-1]);
    }
}