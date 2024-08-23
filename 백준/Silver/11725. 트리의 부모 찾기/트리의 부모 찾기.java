import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list[] = new LinkedList[n + 1];
        boolean visited[] = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n + 1];
        q.add(1);

        while(!q.isEmpty()) {
            int x = q.poll();
            visited[x] = true;
            for(int i = 0; i < list[x].size(); i++) {
                int y = list[x].get(i);
                if(!visited[y]) {
                    q.add(y);
                    ans[y] = x;
                    visited[y] = true;
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}
