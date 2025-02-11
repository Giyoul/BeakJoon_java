import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int houseCount, roadCount;
    public static ArrayList<Node>[] map;
    public static boolean[] visited;
    public static long sum = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        houseCount = Integer.parseInt(st.nextToken());
        roadCount = Integer.parseInt(st.nextToken());
        map = new ArrayList[houseCount + 1];
        for (int i = 0; i <= houseCount; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 0; i < roadCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, weight));
            map[to].add(new Node(from, weight));
        }

        prim();

        System.out.println(sum);
    }

    public static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[houseCount + 1];

        pq.add(new Node(1, 0));

        int edgeCount = 0;
        long max = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.to]) continue;

            visited[node.to] = true;
            sum += node.weight;
            edgeCount++;
            max = Math.max(max, node.weight);

            if(edgeCount == houseCount) break;

            for(Node next : map[node.to]) {
                if(!visited[next.to]) pq.add(next);
            }
        }

        sum -= max;
    }

    public static class Node implements Comparable<Node>{
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}
