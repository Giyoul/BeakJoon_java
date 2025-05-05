import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int testcase, n, count;
    static int[] graph;
    static boolean[] visited, done;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++) {
            n = Integer.parseInt(br.readLine());
            count = 0;
            graph = new int[n + 1];
            visited = new boolean[n+1];
            done = new boolean[n+1];

            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= n; j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j <= n; j++) {
                if(!done[j]){
                    dfs(j);
                }
            }
            System.out.println(n - count);
        }

    }

    public static void dfs(int n) {
        if(visited[n]){
            done[n] = true;
            count++;
        } else {
            visited[n] = true;
        }

        if(!done[graph[n]]){
            dfs(graph[n]);
        }

        visited[n] = false;
        done[n] = true;
    }
}