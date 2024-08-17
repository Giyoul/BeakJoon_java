import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] map;
    static String[] command;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            map = new int[10000];
            visited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int endNum = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            q.add(startNum);
            visited[startNum] = true;

            while (!q.isEmpty() && !visited[endNum]) {
                int token = q.poll();

                int mulNum = multipleRegister(token);
                int subNum = subRegister(token);
                int LShiftNum = LShiftRegister(token);
                int RShiftNum = RShiftRegister(token);

                if (!visited[mulNum]) {
                    visited[mulNum] = true;
                    q.add(mulNum);
                    map[mulNum] = map[token] + 1;
                    command[mulNum] = command[token] + "D";
                }

                if (!visited[subNum]) {
                    visited[subNum] = true;
                    q.add(subNum);
                    map[subNum] = map[token] + 1;
                    command[subNum] = command[token] + "S";
                }

                if (!visited[LShiftNum]) {
                    visited[LShiftNum] = true;
                    q.add(LShiftNum);
                    map[LShiftNum] = map[token] + 1;
                    command[LShiftNum] = command[token] + "L";
                }

                if (!visited[RShiftNum]) {
                    visited[RShiftNum] = true;
                    q.add(RShiftNum);
                    map[RShiftNum] = map[token] + 1;
                    command[RShiftNum] = command[token] + "R";
                }
            }

            System.out.println(command[endNum]);
        }



    }

    public static int multipleRegister(int n) {
        return n * 2 % 10000;
    }

    public static int subRegister(int n) {
        return n == 0 ? 9999 : n - 1;
    }

    public static int LShiftRegister(int n) {
        int shift = n / 1000;
        return n % 1000 * 10 + shift;
    }

    public static int RShiftRegister(int n) {
        int shift = n % 10;
        return n / 10 + shift * 1000;
    }
}
