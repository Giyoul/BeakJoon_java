import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] tree;
    public static int[] dp;
    public static boolean[] visited;
    public static int node, root, query;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        root = Integer.parseInt(st.nextToken());
        query = Integer.parseInt(st.nextToken());

        tree = new ArrayList[node + 1];
        dp = new int[node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i <= node; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }

        DFS(root);

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println("#" + i + ": " + dp[i]);
//        }

        for (int i = 0; i < query; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }

    public static int DFS(int node) {
        if (visited[node]) {
            return dp[node];  // 이미 방문한 경우, 저장된 값 반환
        }
        visited[node] = true;

        int sum = 1;  // 자기 자신 포함
        for (int currentNode : tree[node]) {
            if (!visited[currentNode]) {
                sum += DFS(currentNode);
            }
        }
        dp[node] = sum;  // 서브트리 크기 저장
        return sum;
    }
}
