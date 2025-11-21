import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maleCount = Integer.parseInt(st.nextToken());
        int femaleCount = Integer.parseInt(st.nextToken());

        List<Integer> male = new ArrayList<>();
        List<Integer> female = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= maleCount; i++) {
            male.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= femaleCount; ++i) {
            female.add(Integer.parseInt(st.nextToken()));
        }

        male.sort(null);
        female.sort(null);

        int[][] dp = new int[maleCount + 1][femaleCount + 1];

        for (int i = 1; i <= maleCount; i++) {
            for (int j = 1; j <= femaleCount; j++) {
                dp[i][j] = dp[i - 1][j - 1] + Math.abs(male.get(i - 1) - female.get(j - 1));
                if (i > j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                } else if (i < j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[maleCount][femaleCount]);
    }
}