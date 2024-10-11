import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Node>[] busMap;
    static boolean visited[];
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        busMap = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            busMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            busMap[start].add(new Node(end, w));
        }

        st = new StringTokenizer(br.readLine());

        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        dijkstra(startCity);

        bw.write(dist[endCity] + "");
        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node>{
        int arrive, weight;

        Node(int arrive, int weight) {
            this.arrive = arrive;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node b) {
            return weight - b.weight;
        }
    }

    public static void dijkstra(int startCity) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(startCity, 0));
        dist[startCity] = 0;

        while(!que.isEmpty()) {
            Node currBus = que.poll();
            int currEnd = currBus.arrive;

            if(!visited[currEnd]) {
                visited[currEnd] = true;

                for(Node b : busMap[currEnd]) {
                    if(!visited[b.arrive] && dist[b.arrive]>dist[currEnd]+b.weight) { //지나가지 않았고,
                        dist[b.arrive] = dist[currEnd]+b.weight;
                        que.offer(new Node(b.arrive, dist[b.arrive])); //우선순위 큐로서, weight가 작은것부터
                    }
                }
            }
        }
    }
}