import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long[] posX = new long[n+1];
        long[] posY = new long[n+1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            posX[i] = Long.parseLong(st.nextToken());
            posY[i] = Long.parseLong(st.nextToken());
        }

        long sumA = 0;
        long sumB = 0;
        posX[n] = posX[0];
        posY[n] = posY[0];
        for (int i = 0; i < n; i++) {
            sumA += posX[i] * posY[i + 1];
            sumB += posX[i + 1] * posY[i];
        }

        String area = String.format("%.1f", (Math.abs(sumA - sumB) / 2.0));
        System.out.println(area);
    }
}
