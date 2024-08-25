import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][k];
            int[][] max = new int[2][k];

            st = new StringTokenizer(br.readLine());
            st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                arr[0][j] = Integer.parseInt(st.nextToken());
                arr[1][j] = Integer.parseInt(st1.nextToken());
            }

            if (k == 1) {
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue;
            }
            
            max[0][0] = arr[0][0];
            max[1][0] = arr[1][0];
            max[0][1] = max[1][0] + arr[0][1];
            max[1][1] = max[0][0] + arr[1][1];

            int ans = Math.max(Math.max(max[0][0], max[1][0]), Math.max(max[0][1], max[1][1]));
            for (int j = 2; j < k; j++) {
                max[0][j] = Math.max(max[1][j-1], max[1][j-2]) + arr[0][j];
                max[1][j] = Math.max(max[0][j-1], max[0][j-2]) + arr[1][j];
                ans = Math.max(ans, Math.max(max[0][j], max[1][j]));
            }
            System.out.println(ans);
        }
    }
}
