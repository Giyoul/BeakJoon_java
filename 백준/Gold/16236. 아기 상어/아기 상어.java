import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Node current = null;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if(value == 9){
                    current = new Node(j, i, 0);
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int ate = 0;
        int move = 0;

        while (true) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[][] visited = new boolean[n][n];

            pq.add(new Node(current.x, current.y, 0));
            visited[current.y][current.x] = true;
            boolean isAte = false;

            while(!pq.isEmpty()){
                current = pq.poll();

                if (map[current.y][current.x] != 0 && map[current.y][current.x] < size) {
                    map[current.y][current.x] = 0;
                    isAte = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx] || map[ny][nx] > size){continue;}

                    pq.add(new Node(nx, ny, current.dist + 1));
                    visited[ny][nx] = true;
                }
            }

            if (!isAte) {
                break;
            } else {
                ate++;
                move += current.dist;
            }
            if (ate == size) {
                size++;
                ate = 0;
            }
        }

        System.out.println(move);
    }

    public static class Node implements Comparable<Node> {
        public int x;
        public int y;
        public int dist;
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n){
            if (this.dist != n.dist){
                return Integer.compare(this.dist, n.dist); // 거리 짧은거
            } else if (this.y != n.y) { // y 좌표가 작은 순
                return Integer.compare(this.y, n.y);
            } else {    // x 좌표가 작은 순
                return Integer.compare(this.x, n.x);
            }
        }
    }
}