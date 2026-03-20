import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        List<Long> list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            list.add(Long.parseLong(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        long start = 1;
        long end = list.get(0);
        long ans = 0;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;

            for (Long aLong : list) {
                sum += aLong / mid;
            }
            if (sum >= N) {
                start = mid + 1;
                if (mid >= ans) {
                    ans = mid;
                }
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
