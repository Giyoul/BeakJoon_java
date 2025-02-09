import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Node>[] tree;
    public static int vertex, edge;
    public static boolean[] visited;
    public static long answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        tree = new ArrayList[vertex + 1];
        visited = new boolean[vertex + 1];
        for(int i = 1; i <= vertex; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, weight));
            tree[to].add(new Node(from, weight));
        }

        prim();

        System.out.println(answer);
    }

    public static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.to;
            int weight = node.weight;

            if (visited[current]) continue;
            visited[current] = true;
            answer += weight;

            for(Node next : tree[current]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }

        }

        for(int i = 1; i <= vertex; i++) {
            visited[i] = true;
            long max = Long.MAX_VALUE;
            boolean searched = false;
            for(Node target : tree[i]) {
                if (!visited[target.to]) {
                    if (target.weight <= max) {
                        searched = true;
                        max = target.weight;
                    }
                }
            }
            if (searched) {
                answer += max;
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
