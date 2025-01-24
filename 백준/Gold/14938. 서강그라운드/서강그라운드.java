import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, r;
    public static ArrayList<ArrayList<Node>> map;
    public static int[] itemNum;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        itemNum = new int[n + 1];

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            itemNum[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            map.get(from).add(new Node(to, distance));
            map.get(to).add(new Node(from, distance));
        }

        visited = new boolean[n + 1];
        dist = new int[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(dijkstra(i), answer);
        }

        System.out.println(answer);
    }

    public static int dijkstra(int start) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.nodeNum]) {
                visited[node.nodeNum] = true;

                for (Node connectedNode : map.get(node.nodeNum)) {
                    if (!visited[connectedNode.nodeNum] &&
                            dist[connectedNode.nodeNum] > dist[node.nodeNum] + connectedNode.value) {
                        dist[connectedNode.nodeNum] = dist[node.nodeNum] + connectedNode.value;
                        pq.add(new Node(connectedNode.nodeNum, dist[connectedNode.nodeNum]));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                answer += itemNum[i];
            }
        }

        return answer;
    }

    public static class Node implements Comparable<Node> {
        int value;
        int nodeNum;

        public Node(int nodeNum, int value) {
            this.value = value;
            this.nodeNum = nodeNum;
        }

        @Override
        public int compareTo(Node o) { // 오름차순
            return this.value - o.value;
        }
    }
}
