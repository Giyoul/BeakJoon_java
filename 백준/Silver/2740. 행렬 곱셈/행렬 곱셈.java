/*
 * 행렬문제
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] pre = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                pre[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int M2 = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] pre2 = new int[M2][K];
        for(int i=0; i<M2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                pre2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                int sum = 0;
                for(int k = 0; k < M; k++) {
					sum += pre[i][k] * pre2[k][j];
				}
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

}

