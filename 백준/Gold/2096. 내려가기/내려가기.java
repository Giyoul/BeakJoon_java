import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] src = new int[n][3];
        int[][] maxBoard = new int[n][3];
        int[][] minBoard = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                src[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxBoard[0][0] = src[0][0];
        maxBoard[0][1] = src[0][1];
        maxBoard[0][2] = src[0][2];
        minBoard[0][0] = src[0][0];
        minBoard[0][1] = src[0][1];
        minBoard[0][2] = src[0][2];

        for (int i = 1; i < n; i++) {
            maxBoard[i][0] += Math.max(maxBoard[i-1][0], maxBoard[i-1][1]) + src[i][0];
            maxBoard[i][1] += Math.max(Math.max(maxBoard[i-1][0], maxBoard[i-1][1]), maxBoard[i-1][2]) + src[i][1];
            maxBoard[i][2] += Math.max(maxBoard[i-1][1], maxBoard[i-1][2]) + src[i][2];

            minBoard[i][0] += Math.min(minBoard[i-1][0], minBoard[i-1][1]) + src[i][0];
            minBoard[i][1] += Math.min(Math.min(minBoard[i-1][0], minBoard[i-1][1]), minBoard[i-1][2]) + src[i][1];
            minBoard[i][2] += Math.min(minBoard[i-1][1], minBoard[i-1][2]) + src[i][2];
        }

        sb.append(Math.max(Math.max(maxBoard[n-1][0], maxBoard[n-1][1]), maxBoard[n-1][2])
        + " "
        + Math.min(Math.min(minBoard[n-1][0], minBoard[n-1][1]), minBoard[n-1][2]));

        System.out.println(sb);
    }
}