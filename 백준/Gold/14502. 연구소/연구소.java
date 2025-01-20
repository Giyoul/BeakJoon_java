import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int height, width;
    public static int[][] map;
    public static int maxRoom = 0;
    public static int[] dirX = {1, -1, 0, 0};
    public static int[] dirY = {0, 0, 1, -1};
    public static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];

        for(int i = 0; i < height; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);

        System.out.println(maxRoom);
    }

    public static void buildWall(int wallCount) {
        if(wallCount == 3){
            spreadVirus();
            return;
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    buildWall(wallCount + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus() {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[height][width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(map[i][j] == 2){
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[][] newMap = new int[height][width];
        for(int i = 0; i < height; i++){
            newMap[i] = map[i].clone();
        }

        while(!q.isEmpty()){
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = node.x + dirX[i];
                int newY = node.y + dirY[i];

                if(newX >= 0 && newY < height && newY >= 0 && newX < width && newMap[newY][newX] == 0 && !visited[newY][newX]){
                    newMap[newY][newX] = 2;
                    visited[newY][newX] = true;
                    q.add(new Node(newY, newX));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if (newMap[i][j] == 0) {
                    count++;
                }
            }
        }

        if(count > maxRoom){
            maxRoom = count;
        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}