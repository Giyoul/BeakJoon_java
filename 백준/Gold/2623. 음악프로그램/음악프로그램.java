import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int singerCount, PDCount;
    static int numberCount;
    static int[] indegree;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        singerCount = Integer.parseInt(st.nextToken());
        PDCount = Integer.parseInt(st.nextToken());
        indegree = new int[singerCount + 1];
        graph = new ArrayList[singerCount + 1];

        for(int i = 0; i <= singerCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < PDCount; i++) {
            st = new StringTokenizer(br.readLine());
            numberCount = Integer.parseInt(st.nextToken());
            int from;
            int to = Integer.parseInt(st.nextToken());

            for(int j = 0; j < numberCount-1; j++) {
                from = to;
                to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                indegree[to]++;
            }
        }

        topologicalSort();

        boolean flag = false;
        for (int i = 1; i < graph.length; i++) {
            if(indegree[i] != 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("0");
        } else {
            System.out.println(sb);
        }
    }

    public static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < graph.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append("\n");

            for (int i = 0; i < graph[current].size(); i++) {
                int next = graph[current].get(i);
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}