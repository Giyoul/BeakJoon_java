import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static long D;
    // 2차원 배열 대신 1차원 배열 3개로 분리함요
    static int[] A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Long.parseLong(st.nextToken());

        // 분리한 만큼 초기화도 더 해주고
        A = new int[K];
        B = new int[K];
        C = new int[K];

        int minStart = N;
        int maxEnd = 1;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            
            // 실제 도토리가 놓일 수 있는 범위만 한정하고
            if (A[i] < minStart) minStart = A[i];
            if (B[i] > maxEnd) maxEnd = B[i];
        }

        // 이분 탐색 범위 최적화해주면, 리소스 사용량 줄어요
        // 지난번에도 그러던데 임계값 설정 최적화 생각 히히
        int lo = minStart;
        int hi = maxEnd;
        int answer = maxEnd;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int mid) {
        long cnt = 0;
        for (int i = 0; i < K; i++) {
            // 규칙의 끝 지점과 현재 mid 중 작은 값을 선택
            int endPoint = (B[i] < mid) ? B[i] : mid;
            
            if (A[i] <= endPoint) {
                cnt += (endPoint - A[i]) / C[i] + 1;
            }

            if (cnt >= D) return true; // 조기 종료
        }
        return false;
    }
}