import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int[] time = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(time, Integer.MAX_VALUE);

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        visited[from] = true;
        time[from] = 0;

        while (!q.isEmpty()) {
            int token = q.poll();

            if (token * 2 <= 100000 && token * 2 > 0) {
                if(time[token * 2] > time[token]) {
                    q.add(token * 2);
                    visited[token * 2] = true;
                    time[token * 2] = time[token];
                }
            }
            if (token - 1 >= 0) {
                if (!visited[token - 1] && time[token - 1] > time[token] + 1) {
                    q.add(token - 1);
                    visited[token - 1] = true;
                    time[token - 1] = time[token] + 1;
                }
            }
            if (token + 1 <= 100000) {
                if(!visited[token + 1] && time[token + 1] > time[token] + 1) {
                    q.add(token + 1);
                    visited[token + 1] = true;
                    time[token + 1] = time[token] + 1;
                }
            }
        }

        System.out.println(time[to]);
    }
}
