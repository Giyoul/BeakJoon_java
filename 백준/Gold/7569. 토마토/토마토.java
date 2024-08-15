import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][][] map;
    public final static int[] dirx = {1, 0, -1, 0, 0, 0};
    public final static int[] diry = {0, 1, 0, -1, 0, 0};
    public final static int[] dirz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][][] countMap;


        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        map = new int[z][y][x];
        countMap = new int[z][y][x];
        Queue<xyzPos> q = new LinkedList<>();

        for(int i = 0; i < z; i++) {
            for(int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < x; k++) {
                    int token = Integer.parseInt(st.nextToken());
                    map[i][j][k] = token;
                    if (token == 1) {
                        q.add(new xyzPos(k, j, i));
                        countMap[i][j][k] = 0;
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            xyzPos pos = q.poll();
            for(int i = 0; i < 6; i++) {
                int currentX = pos.x + dirx[i];
                int currentY = pos.y + diry[i];
                int currentZ = pos.z + dirz[i];

                if(currentZ < 0 || currentZ >= z || currentY < 0 || currentY >= y || currentX < 0 || currentX >= x) continue;
                if (map[currentZ][currentY][currentX] == -1) continue;
                if (map[currentZ][currentY][currentX] == 1) continue;
                if (map[currentZ][currentY][currentX] == 0) {
                    map[currentZ][currentY][currentX] = 1;
                    countMap[currentZ][currentY][currentX] = countMap[pos.z][pos.y][pos.x] + 1;
                    q.add(new xyzPos(currentX, currentY, currentZ));
                }
            }
        }

        int max = 0;
        for(int i = 0; i < z; i++) {
            for(int j = 0; j < y; j++) {
                for(int k = 0; k < x; k++) {
                    if (map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    if (countMap[i][j][k] > max) max = countMap[i][j][k];
                }
            }
        }

        System.out.println(max);
    }

    public static class xyzPos {
        int x;
        int y;
        int z;

        xyzPos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
