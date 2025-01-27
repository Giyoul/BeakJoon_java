
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int height, width, seconds;
    static int filterY1 = -1, filterY2 = -1;
    static int[][] dirts;
    static int[] dirx = {-1, 1, 0, 0};
    static int[] diry = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        seconds = Integer.parseInt(st.nextToken());

        dirts = new int[height][width];

        for(int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    if (filterY1 == -1) {
                        filterY1 = i;
                    } else {
                        filterY2 = i;
                    }
                }
                dirts[i][j] = x;
            }
        }

        for (int i = 0; i < seconds; i++) {
            dirts = spread();
            filtering();
//            System.out.println("Test " + i);
//            test();
        }
        int ans = 0;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                ans += dirts[i][j];
            }
        }
        System.out.println(ans+2);
    }

    public static int[][] spread() {
        int[][] newMap = new int[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                int spreadAmount = dirts[i][j] / 5;
                for(int k = 0; k < 4; k++) {
                    int x = j + dirx[k];
                    int y = i + diry[k];
                    if(x >= 0 && y < height && y >= 0 && x < width && !(x == 0 && y == filterY1) && !(x == 0 && y == filterY2)) {
                        newMap[i][j] -= spreadAmount;
                        newMap[y][x] += spreadAmount;
                    }
                }

            }
        }
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                newMap[i][j] += dirts[i][j];
            }
        }

        return newMap;
    }

    public static void filtering() {
        int tmp1 = 0;
        int tmp2 = dirts[filterY1][1];
        dirts[filterY1][1] = 0;
        for (int i = 1; i < width - 1; i++) { // 위쪽
            tmp1 = dirts[filterY1][i + 1];
            dirts[filterY1][i + 1] = tmp2;
            tmp2 = tmp1;
        }
        for (int i = filterY1-1; i >= 0; i--) {
            tmp1 = dirts[i][width - 1];
            dirts[i][width - 1] = tmp2;
            tmp2 = tmp1;
        }
        for(int i = width-1; i > 0; i--) {
            tmp1 = dirts[0][i - 1];
            dirts[0][i - 1] = tmp2;
            tmp2 = tmp1;
        }
        for (int i = 1; i < filterY1; i++) {
            tmp1 = dirts[i][0];
            dirts[i][0] = tmp2;
            tmp2 = tmp1;
        }

        tmp2 = dirts[filterY2][1];
        dirts[filterY2][1] = 0;
        for (int i = 1; i < width - 1; i++) { // 위쪽
            tmp1 = dirts[filterY2][i + 1];
            dirts[filterY2][i + 1] = tmp2;
            tmp2 = tmp1;
        }
        for (int i = filterY2+1; i <= height-1; i++) {
            tmp1 = dirts[i][width - 1];
            dirts[i][width - 1] = tmp2;
            tmp2 = tmp1;
        }
        for(int i = width-1; i > 0; i--) {
            tmp1 = dirts[height-1][i - 1];
            dirts[height-1][i - 1] = tmp2;
            tmp2 = tmp1;
        }
        for (int i = height-2; i > filterY2; i--) {
            tmp1 = dirts[i][0];
            dirts[i][0] = tmp2;
            tmp2 = tmp1;
        }
    }



    public static void test() {
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                System.out.print(dirts[i][j] + " ");
            }
            System.out.println();
        }
    }
}