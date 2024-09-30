import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] map;
    public static boolean[][][] visited;
    public static int n, m;
    public static int[] dirx = {1, 0, -1, 0};
    public static int[] diry = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1][2];  // 0은 벽을 안부쉈을 떄, 1은 벽을 부쉈을 때

        for (int i = 1; i <= n; i++) {
            String line = br.readLine(); // 한 줄 입력을 받아서 처리
            for (int j = 1; j <= m; j++) {
                map[i][j] = line.charAt(j - 1) - '0'; // 각 문자를 숫자로 변환
            }
        }

        visited[1][1][0] = true;
        BFS(new Node(1, 1, 1, false));
    }

    public static class Node {
        public int x, y;
        public int weight;
        public boolean wallBreak;

        public Node(int x, int y, int weight, boolean wallBreak) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.wallBreak = wallBreak;
        }
    }

    public static void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == m && current.y == n) { // 목적지 도달 확인
                System.out.println(current.weight);
                return; // 경로를 찾으면 종료
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dirx[i];
                int nextY = current.y + diry[i];

                // 범위 체크 (1 ≤ nextX ≤ n, 1 ≤ nextY ≤ m)
                if (nextX < 1 || nextY < 1 || nextX > m || nextY > n) {
                    continue;
                }

                if (map[nextY][nextX] == 0) { // 1. 벽이 아니고,
                    if (!current.wallBreak && !visited[nextY][nextX][0]) { // 벽을 부순 적 없을 때
                        visited[nextY][nextX][0] = true;
                        q.add(new Node(nextX, nextY, current.weight + 1, false));
                    } else if (current.wallBreak && !visited[nextY][nextX][1]) { // 벽을 부순 적이 있을 때
                        visited[nextY][nextX][1] = true;
                        q.add(new Node(nextX, nextY, current.weight + 1, true));
                    }
                } else if (map[nextY][nextX] == 1) { // 2. 벽인데,
                    if (!current.wallBreak && !visited[nextY][nextX][1]) { // 벽을 아직 부수지 않았을 때
                        visited[nextY][nextX][1] = true;
                        q.add(new Node(nextX, nextY, current.weight + 1, true));
                    }
                }
            }
        }

        // 목적지에 도달할 수 없을 때
        System.out.println("-1");
    }
}
