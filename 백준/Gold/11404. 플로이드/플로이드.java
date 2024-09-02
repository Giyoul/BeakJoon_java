import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if (i == j) {
                    list[i][j] = 0;
                } else {
                    list[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a][b] = Math.min(list[a][b], c);
        }

        // 플로이드 와샬
        for(int k = 1; k <= n; k++){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(list[i][k] != Integer.MAX_VALUE && list[k][j] != Integer.MAX_VALUE){
                        list[i][j] = Math.min(list[i][k] + list[k][j], list[i][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if (list[i][j] == Integer.MAX_VALUE) {
                    sb.append("0 ");
                } else {
                    sb.append(list[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
