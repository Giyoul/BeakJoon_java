import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] able = new boolean[n][n];
        int[][] output = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                if (Integer.parseInt(st.nextToken()) == 1) {
                    able[i][j] = true;
                    output[i][j] = 1;
                } else {
                    able[i][j] = false;
                    output[i][j] = 0;
                }
            }
        }

        // 플로이드 - 와샬 알고리즘
        for(int i = 0; i < n; i++){ // 중간 노드
            for(int j = 0; j < n; j++){ // 출발 노드
                for(int k = 0; k < n; k++){ // 도착 노드
                    if (able[j][i] && able[i][k]) {
                        able[j][k] = true;
                        output[j][k] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
