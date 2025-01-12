import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int node, edge;
    public static int[] dist;
    public static ArrayList<ArrayList<Node>> arr;
    public static final int MAXIMUM = 200000000;
//    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
//        visited = new boolean[node + 1];
        dist = new int[node + 1];
        Arrays.fill(dist, MAXIMUM);

        for (int i = 1; i <= node + 1; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Node(b, c));
            arr.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int node1 = Integer.parseInt(st.nextToken());
        int node2 = Integer.parseInt(st.nextToken());

        int node1First = 0;
        node1First += dijkstra(1, node1);
        node1First += dijkstra(node1, node2);
        node1First += dijkstra(node2, node);

        int node2First = 0;
        node2First += dijkstra(1, node2);
        node2First += dijkstra(node2, node1);
        node2First += dijkstra(node1, node);

        int ans = (node1First >= MAXIMUM && node2First >= MAXIMUM) ? -1 : Math.min(node1First, node2First);
        System.out.println(ans);
    }

    public static class Node implements Comparable<Node>{
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static int dijkstra(int start, int end){
        Arrays.fill(dist, MAXIMUM);
//        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.end;
            for(Node neighbor : arr.get(cur)){
                if(dist[cur] + neighbor.weight < dist[neighbor.end]){
                    dist[neighbor.end] = dist[cur] + neighbor.weight;
                    pq.add(new Node(neighbor.end, dist[neighbor.end]));
                }
            }

        }
        return dist[end];
    }
}