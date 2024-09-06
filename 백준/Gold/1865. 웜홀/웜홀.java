import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, w;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testcases = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcases; i++) {
            graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];

            for(int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < m + w; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if (j < m) {
                    graph.get(start).add(new Node(end, weight));
                    graph.get(end).add(new Node(start, weight));
                } else {
                    graph.get(start).add(new Node(end, -weight));
                }
            }

            sb.append(bellmanFord() ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord() {
        Arrays.fill(dist, 999999999);
        dist[1] = 0; // 시작점은 0으로 초기화.
        boolean update = false;
        for (int i = 1; i < n; i++) {
            update = false;
            for (int j = 1; j <= n; j++) {
                for (Node road : graph.get(j)) {
                    if (dist[road.endpoint] > dist[j] + road.weight) {
                        dist[road.endpoint] = dist[j] + road.weight;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        if (update) {
            for (int i = 1; i <= n; i++) {
                for (Node road : graph.get(i)) {
                    if (dist[road.endpoint] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static class Node{
        int endpoint;
        int weight;

        public Node(int endpoint, int weight) {
            this.endpoint = endpoint;
            this.weight = weight;
        }
    }
}
