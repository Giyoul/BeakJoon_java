import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int from, to, next;
    public static int minTime = Integer.MAX_VALUE;
    public static int minTimeCount = 0;
    public static int[] time = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        if (from == to) {
            System.out.print("0\n1");
        } else {
            DFS();
            System.out.println(minTime - 1);
            System.out.println(minTimeCount);
        }
    }

    public static void DFS() {
        Queue<Integer> q = new LinkedList<>();

        q.add(from);
        time[from] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (minTime < time[now]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = now * 2;
                } else if (i == 1) {
                    next = now + 1;
                } else {
                    next = now - 1;
                }
                if (next > 100000 || next < 0) {
                    continue;
                }

                if (next == to) {
                    if (minTime > time[now] + 1) {
                        minTime = time[now] + 1;
                        minTimeCount = 1;
                    }
                    else if(minTime == time[now] + 1) {
                        minTimeCount++;
                    }
                    continue;
                }

                if (time[now] + 1 <= time[next] || time[next] == 0) {
                    time[next] = time[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
