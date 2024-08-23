import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(remainder(a, b, c));
    }

    // 모듈러 산술
    public static long remainder(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        } else {
            long half = remainder(a, b / 2, c);
            if(b % 2 == 1) {
                return (half * half % c) * a % c;
            }
            return half * half % c;
        }
    }
}
