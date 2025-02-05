import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] numbers = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        int frontPointer = 0;
        int backPointer = n - 1;
        long min = Long.MAX_VALUE;
        int ansFrontPointer = frontPointer, ansBackPointer = backPointer;

        while (frontPointer < backPointer) {
            long sum = numbers[frontPointer] + numbers[backPointer];

            // 0에 더 가까운 값을 찾으면 업데이트
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                ansFrontPointer = frontPointer;
                ansBackPointer = backPointer;
            }

            // 합이 음수면 frontPointer 증가, 양수면 backPointer 감소
            if (sum < 0) {
                frontPointer++;
            } else {
                backPointer--;
            }
        }

        System.out.println(numbers[ansFrontPointer] + " " + numbers[ansBackPointer]);
    }
}
