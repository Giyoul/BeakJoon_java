import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j], visited);   // ㅗ 모양 블럭을 제외한 나머지의 최대값 찾기
                visited[i][j] = false;
                excepted(i, j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int i, int j, int count, int sum, boolean[][] visited) {
        if (count >= 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int x = j + dirX[k];
            int y = i + dirY[k];

            if (x < 0 || x >= M || y < 0 || y >= N || visited[y][x]) {
                continue;
            }

            visited[y][x] = true;
            dfs(y, x, count+1, sum+map[y][x], visited);
            visited[y][x] = false;
        }
    }

    static void excepted(int i, int j) {
        // ㅏ
        if (i < N - 2 && j < M - 1) {
            max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1]);
        }

        // ㅗ
        if (i > 0 && j < M - 2) {
            max = Math.max(max, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 1]);
        }

        // ㅓ
        if (i < N - 2 && j >0) {
            max = Math.max(max, map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j - 1]);
        }

        // ㅜ
        if (i < N - 1 && j < M - 2) {
            max = Math.max(max, map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1]);
        }
    }
}
