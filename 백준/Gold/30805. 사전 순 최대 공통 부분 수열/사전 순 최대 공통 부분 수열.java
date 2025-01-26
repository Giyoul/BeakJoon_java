import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n, m;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int idxA = 1;
        int idxB = 1;
        Queue<Integer> word = new ArrayDeque<>();

        while (idxA <= n && idxB <= m) {
            int result = 0;
            for (int i = idxA; i <= n; i++) {  // 계속해서 가장 큰 것들만 선택
                for (int j = idxB; j <= m; j++) {
                    if (A[i] == B[j]) result = Math.max(result, A[i]);
                }
            }

            if (result != 0) {
                word.add(result);
                while (A[idxA] != result) idxA++;
                while (B[idxB] != result) idxB++;
                idxA++;
                idxB++;
            } else break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(word.size()).append("\n");
        while (!word.isEmpty()) sb.append(word.poll()).append(" ");
        System.out.println(sb);
        br.close();
    }
}