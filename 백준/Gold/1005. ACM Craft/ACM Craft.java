import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int testCase;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        testCase = Integer.parseInt(br.readLine());

        for(int k = 0; k < testCase; k++) {
            int numberOfBuilding, numberOfRule, destination;
            int[] time;
            int[] destinationTime;
            int[] degree;
            ArrayList<Integer>[] tree;
            st = new StringTokenizer(br.readLine());
            numberOfBuilding  = Integer.parseInt(st.nextToken());
            numberOfRule  = Integer.parseInt(st.nextToken());

            time = new int[numberOfBuilding + 1];
            destinationTime = new int[numberOfBuilding + 1];
            degree = new int[numberOfBuilding + 1];
            tree = new ArrayList[numberOfBuilding + 1];

            st = new StringTokenizer(br.readLine());
            tree[0] = new ArrayList<>();
            for(int i = 1; i <= numberOfBuilding; i++){
                time[i] = Integer.parseInt(st.nextToken());
                tree[i] = new ArrayList<>();
            }

            for(int i = 1; i <= numberOfRule; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                degree[to]++;

                tree[from].add(to);
            }

            destination = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < degree.length; i++) {
                if (degree[i] == 0) {
                    destinationTime[i] = time[i];
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()){
                int node = queue.poll();

                for(int i = 0 ; i < tree[node].size(); i++){
                    int nextNode = tree[node].get(i);
                    destinationTime[nextNode] = Math.max(time[nextNode] + destinationTime[node], destinationTime[nextNode]);
                    degree[nextNode]--;
                    if(degree[nextNode] == 0) queue.add(nextNode);
                }
            }

            sb.append(destinationTime[destination]).append('\n');
        }
        System.out.println(sb);
    }
}