import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int gap;
    static int from, to;
    static long target;
    static long[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        target = Long.parseLong(st.nextToken());
        gap = n;

        sum = new long[n+1];
        st = new StringTokenizer(br.readLine());

        sum[0] = Long.parseLong(st.nextToken());

        for(int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + Long.parseLong(st.nextToken());
        }

        from = 0;
        to = -1;
        for(int i = 0; i < n; i++) {
            if(sum[i] >= target){
                to = i;
                break;
            }
        }
        if(to == -1){
            System.out.println(0);
            return;
        }

        gap = Math.min(gap, updateGap());

        for (int i = to; i < n; i++) {
            to++;
            gap = Math.min(gap, updateGap());
        }

        System.out.println(gap);
    }

    public static int updateGap() {
        for(int i = from; i <= to; i++) {
            if(sum[to] - sum[i] < target){
                from = i;
                return to - i + 1;
            }
        }

        return 0;
    }
}
