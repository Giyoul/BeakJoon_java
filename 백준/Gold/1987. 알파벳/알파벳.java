import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int row_input, column_input;
    public static boolean[] visited;
    public static int[][] map;
    public static int result = 0;
    public static final int[] dirx = {-1, 1, 0, 0};
    public static final int[] diry = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row_input = Integer.parseInt(st.nextToken());
        column_input = Integer.parseInt(st.nextToken());

        visited = new boolean[26];
        map = new int[row_input][column_input];

        for (int i = 0; i < row_input; i++) {
            String str = br.readLine();
            for (int j = 0; j < column_input; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }

        DFS(0, 0, 1);
        System.out.println(result);
    }

    public static void DFS(int row, int col, int sum) {
        if(sum > result) result = sum;

        visited[map[row][col]] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirx[i];
            int newCol = col + diry[i];

            if(newRow >= 0 && newRow < row_input && newCol >= 0 && newCol < column_input) {
                if(!visited[map[newRow][newCol]]){
                    DFS(newRow, newCol, sum+1);
                }
            }
        }

        visited[map[row][col]] = false;

    }
}