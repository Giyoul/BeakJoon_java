import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Node>[] lists;
    static boolean[] visited;
    static int maxNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        maxNum = 0;

        n = Integer.parseInt(br.readLine());
        lists = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            lists[i] = new LinkedList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to  = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[from].add(new Node(to, weight));
            lists[to].add(new Node(from, weight));
        }

        for (int i = 1; i <= n; i++) {
            if(lists[i].isEmpty()) continue;

            visited = new boolean[n + 1];
            visited[i] = true;
            dfsCheck(i, 0);
        }

        System.out.println(maxNum);
    }

    public static void dfsCheck(int root, int dis) {
        for (Node node : lists[root]){
            if (!visited[node.endPoint]) {
                visited[node.endPoint] = true;
                dfsCheck(node.endPoint, dis + node.weight);
            }
        }
        maxNum = Math.max(maxNum, dis);
    }

    public static class Node {
        int endPoint;
        int weight;

        public Node(int endPoint, int weight) {
            this.endPoint = endPoint;
            this.weight = weight;
        }
    }
}
