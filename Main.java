import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int city;
    public static int bus;
    public static ArrayList<ArrayList<Node>> map;
    public static int ansFrom, ansTo;
    public static int[] busStation;
    public static StringBuilder[] paths;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        busStation = new int[city + 1];
        paths = new StringBuilder[city + 1]; // 경로 저장을 위한 배열

        map = new ArrayList<>();
        for (int i = 0; i <= city; i++) {
            map.add(new ArrayList<>());
            busStation[i] = Integer.MAX_VALUE;
            paths[i] = new StringBuilder(); // StringBuilder 초기화
        }

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(from).add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        ansFrom = Integer.parseInt(st.nextToken());
        ansTo = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(busStation[ansTo]);
        System.out.println(paths[ansTo].toString().split(" ").length);
        System.out.println(paths[ansTo].toString());
    }

    public static void dijkstra() {
        PriorityQueue<Movement> pq = new PriorityQueue<>();
        busStation[ansFrom] = 0;
        pq.add(new Movement(ansFrom, 0));
        paths[ansFrom].append(ansFrom).append(" "); // 시작점 기록

        while (!pq.isEmpty()) {
            Movement movement = pq.poll();

            // 현재 정점의 비용이 이미 더 크면 무시 (최적 경로 X)
            if (movement.totalCost > busStation[movement.location]) continue;

            for (Node node : map.get(movement.location)) {
                int newCost = movement.totalCost + node.cost;

                if (newCost < busStation[node.destination]) {
                    busStation[node.destination] = newCost;
                    pq.add(new Movement(node.destination, newCost));

                    // 최단 경로 갱신
                    paths[node.destination] = new StringBuilder(paths[movement.location]);
                    paths[node.destination].append(node.destination).append(" ");
                }
            }
        }
    }

    public static class Node {
        int destination, cost;
        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static class Movement implements Comparable<Movement> {
        int location, totalCost;

        public Movement(int location, int totalCost) {
            this.location = location;
            this.totalCost = totalCost;
        }

        @Override
        public int compareTo(Movement o) {
            return Integer.compare(this.totalCost, o.totalCost); // 비용이 적은 순으로 정렬
        }
    }
}
