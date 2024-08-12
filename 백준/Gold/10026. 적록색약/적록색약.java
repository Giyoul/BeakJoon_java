import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int normal_person_count = 0;
        int color_blind_count = 0;

        map = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String place = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = place.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    normal_person_count++;
                    bfs(i, j, map[i][j], n);
                }
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    color_blind_count++;
                    bfs(i, j, map[i][j], n);
                }
            }
        }

        System.out.println(normal_person_count + " " + color_blind_count);
    }

    public static void bfs(int x, int y, char target, int n) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx > n - 1 || ny < 0 || ny > n - 1) {
                    continue;
                }
                if(!visited[nx][ny] && target == map[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
