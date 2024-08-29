import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node>[] adj;
    static int[] dist;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        adj = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[v1].add(new Node(v2, weight));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb);
    }

    public static class Node {
        int end_point;
        int weight;

        public Node(int link, int weight) {
            this.end_point = link;
            this.weight = weight;
        }
    }

    public static void dijkstra(int start) {
        boolean[] checked = new boolean[V+1];
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end_point;

            if(checked[cur]) continue;
            checked[cur] = true;

            for(Node node : adj[cur]){
                if(dist[node.end_point] > dist[cur] + node.weight){
                    dist[node.end_point] = dist[cur] + node.weight;
                    queue.add(new Node(node.end_point, dist[node.end_point]));
                }
            }
        }
    }
}
