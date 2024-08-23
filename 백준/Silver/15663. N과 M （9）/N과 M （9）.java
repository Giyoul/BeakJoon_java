import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list;
    static int m;
    static boolean[] visited;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        visited = new boolean[n];
        ans = new int[m];
        Collections.sort(list);

        depth(0);
    }

    public static void depth(int dep) {
        if (dep == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            return;
        }

        int prev = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                int token = list.get(i);
                if (prev != token) {
                    visited[i] = true;
                    ans[dep] = token;
                    prev = token;
                    depth(dep + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
