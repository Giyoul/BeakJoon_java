import java.io.*;
import java.util.ArrayList;

public class Main {
    static int[][] sudoku = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = input.charAt(j) - '0';
                if (sudoku[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        solve(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static boolean solve(int count) {
        if (count == list.size()) return true;

        int y = list.get(count)[0];
        int x = list.get(count)[1];

        boolean[] validList = isValid(y, x);

        for (int i = 1; i <= 9; i++) {
            if (!validList[i]) { // 사용 가능할 경우
                sudoku[y][x] = i;
                if (solve(count + 1)) return true;
                sudoku[y][x] = 0; // 백트래킹
            }
        }

        return false;
    }

    public static boolean[] isValid(int y, int x) {
        boolean[] result = new boolean[10];

        // 행과 열 체크
        for (int i = 0; i < 9; i++) {
            result[sudoku[y][i]] = true;
            result[sudoku[i][x]] = true;
        }

        // 3x3 블록 체크
        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;
        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                result[sudoku[i][j]] = true;
            }
        }

        return result;
    }
}
