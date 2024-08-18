import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀 수

        // 사다리와 뱀의 정보를 담을 맵
        Map<Integer, Integer> board = new HashMap<>();

        // 사다리 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board.put(x, y);
        }

        // 뱀 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board.put(u, v);
        }

        // BFS 초기화
        int[] count = new int[101];
        Arrays.fill(count, Integer.MAX_VALUE); // 최소값으로 초기화
        Queue<Integer> q = new LinkedList<>();

        count[1] = 0; // 시작점
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int dice = 1; dice <= 6; dice++) {
                int next = cur + dice;
                if (next > 100) continue; // 보드의 끝을 넘으면 무시

                if (board.containsKey(next)) {
                    next = board.get(next); // 사다리나 뱀으로 이동
                }

                if (count[next] > count[cur] + 1) {
                    count[next] = count[cur] + 1;
                    q.add(next); // 새로운 칸을 큐에 추가
                }
            }
        }

        // 100번 칸까지 도달하는 최소 횟수 출력
        System.out.println(count[100]);
    }
}
