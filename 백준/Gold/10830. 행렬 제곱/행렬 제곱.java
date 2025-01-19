import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] mat;
    public static int N;
    public static long B;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        mat = new int[N*N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                mat[count++] = Integer.parseInt(st.nextToken());
            }
        }

        int[] res = recur(mat, B);

        StringBuilder sb = new StringBuilder();
        int len = N*N;

        if (B == 1) {
            for (int i = 0; i < N * N; i++) {
                res[i] = res[i] % 1000;
            }
        }

        for (int i = 0; i < len; i++) {
            sb.append(res[i] + " ");
            if (i % N == N - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int[] recur(int[] matin, long exp) {
        if(exp == 1L){
            return mat;
        }

        int[] ret = recur(matin, exp / 2);

        ret = calculate(ret, ret);
        if(exp % 2 == 1L){
            ret = calculate(ret, mat);
        }

        return ret;
    }

    public static int[] calculate(int[] mat1, int[] mat2) {
        int[] result = new int[N*N];

        for (int i = 0; i < N; i++) { // 행
            for (int j = 0; j < N; j++) { // 열
                for (int k = 0; k < N; k++) { // 중간 계산
                    // 2차원 배열 (o1[i][k] * o2[k][j]) -> 1차원 배열로 변환
                    result[i * N + j] += mat1[i * N + k] * mat2[k * N + j];
                    result[i * N + j] %= 1000; // 나머지 연산
                }
            }
        }
        return result;
    }
}