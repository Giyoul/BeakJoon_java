import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        
        int[][] map = new int[size][size];
        for(int[] row : map) {
            Arrays.fill(row, 0);
        }
        
        map[0][0] = triangle[0][0];
        
        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j <= i; j++) {
                map[i+1][j] = Math.max(map[i+1][j], map[i][j] + triangle[i+1][j]);
                map[i+1][j+1] = Math.max(map[i+1][j+1], map[i][j] + triangle[i+1][j+1]);
            }
        }
        
        int max = 0;
        for(int i = 0; i < size; i++) {
            max = Math.max(max, map[size-1][i]);
        }
        
        return max;
    }
}