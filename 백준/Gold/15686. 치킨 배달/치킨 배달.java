import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int min = Integer.MAX_VALUE;
    public static List<Node> chicken = new ArrayList<>();
    public static List<Node> house = new ArrayList<>();
    public static boolean[] chickenVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    house.add(new Node(i, j));
                } else if(num == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        chickenVisited = new boolean[chicken.size()];
        backtracking(0, 0); //m개의 치킨집을 뽑는다.
        System.out.println(min);
    }

    public static void backtracking(int count, int idx) {
        if(count == M) { //치킨 거리의 최솟값을 구한다.
            int total = 0; // 도시의 치킨거리
            for(int i = 0; i < house.size(); i++) {
                int sum = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(chickenVisited[j] == true) { //i번째 집에서부터 j번짜 치킨집 까지의 거리 중 최소값을 구한다.
                        int dist = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);
                        sum = Math.min(sum, dist);
                    }
                }
                total += sum;
            }
            min = Math.min(total, min);
            return;
        }

        for(int i = idx; i < chicken.size(); i++) {
            if(chickenVisited[i] == false) {
                chickenVisited[i] = true;
                backtracking(count + 1, i + 1);
                chickenVisited[i] = false;
            }
        }
    }

    public static class Node {
        public int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}